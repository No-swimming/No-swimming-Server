package com.example.noswimmingserver.domain.student.service

import com.example.noswimmingserver.domain.book.domain.repository.MyBookRepository
import com.example.noswimmingserver.domain.common_user.domain.User
import com.example.noswimmingserver.domain.rank.domain.repository.UserRankRepository
import com.example.noswimmingserver.domain.reading_journal.domain.repository.ReadingJournalRepository
import com.example.noswimmingserver.domain.student.facade.StudentFacade
import com.example.noswimmingserver.domain.student.presentation.dto.response.QueryMyInfoResponse
import com.example.noswimmingserver.global.security.SecurityFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryMyInfoService(
    private val securityFacade: SecurityFacade,
    private val studentFacade: StudentFacade,
    private val readingJournalRepository: ReadingJournalRepository,
    private val myBookRepository: MyBookRepository,
    private val userRankRepository: UserRankRepository,
) {

    @Transactional(readOnly = true)
    fun execute(): QueryMyInfoResponse {
        val user = securityFacade.getCurrentUser()
        val student = studentFacade.getStudentById(user.id)

        return QueryMyInfoResponse(
            email = user.email,
            name = user.queryName(),
            grade = student.grade,
            classNum = student.classNum,
            number = student.number,
            countRejectBook = countUsersRejectBook(user),
            countReadBook = countUsersReadBook(user),
            myRank = queryMyRank(user),
            profileNum = user.profileNum,
        )
    }

    private fun queryMyRank(user: User) =
        (userRankRepository.countAllUsers() - userRankRepository.countLessThanMe(user.id)) + 1

    private fun countUsersReadBook(user: User) = myBookRepository.countByUserId(user.id).toInt()

    private fun countUsersRejectBook(user: User) = readingJournalRepository.countMyReadingJournal(user.id).toInt()
}

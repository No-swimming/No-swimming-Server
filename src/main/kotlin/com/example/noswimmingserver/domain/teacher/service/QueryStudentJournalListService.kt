package com.example.noswimmingserver.domain.teacher.service

import com.example.noswimmingserver.domain.reading_journal.domain.repository.ReadingJournalRepository
import com.example.noswimmingserver.domain.teacher.presentation.dto.response.QueryStudentJournalList
import com.example.noswimmingserver.domain.teacher.presentation.dto.response.QueryStudentJournalList.StudentJournalElement
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryStudentJournalListService(
    private val readingJournalRepository: ReadingJournalRepository,
) {

    @Transactional(readOnly = true)
    fun execute(userId: Long): QueryStudentJournalList {
        val readingJournalList = readingJournalRepository.queryReadingJournalListByUserId(userId)

        val response = readingJournalList.map {
            StudentJournalElement(
                bookId = it.bookId,
                bookNum = it.bookNum,
                title = it.title,
                recordReject = it.recordReject,
                readingJournalType = it.readingJournalType,
                readingJournalId = it.readingJournalId,
            )
        }

        return QueryStudentJournalList(response)
    }
}

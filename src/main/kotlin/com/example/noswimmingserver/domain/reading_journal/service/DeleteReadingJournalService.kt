package com.example.noswimmingserver.domain.reading_journal.service

import com.example.noswimmingserver.domain.reading_journal.domain.repository.ReadingJournalRepository
import com.example.noswimmingserver.domain.reading_journal.exception.CannotDeleteReadingJournalException
import com.example.noswimmingserver.domain.reading_journal.facade.ReadingJournalFacade
import com.example.noswimmingserver.domain.student.facade.StudentFacade
import com.example.noswimmingserver.global.security.SecurityFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeleteReadingJournalService(
    private val securityFacade: SecurityFacade,
    private val studentFacade: StudentFacade,
    private val readingJournalFacade: ReadingJournalFacade,
    private val readingJournalRepository: ReadingJournalRepository,
) {

    @Transactional
    fun execute(readingJournalId: Long) {
        val readingJournal = readingJournalFacade.getReadingJournalById(readingJournalId)

        val user = securityFacade.getCurrentUser()

        val student = studentFacade.getStudentById(user.id)

        if (readingJournal.student != student) {
            throw CannotDeleteReadingJournalException
        }

        readingJournalRepository.delete(readingJournal)
    }
}
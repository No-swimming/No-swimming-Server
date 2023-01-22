package com.example.noswimmingserver.domain.reading_journal.service

import com.example.noswimmingserver.domain.reading_journal.exception.CannotSubmitReadingJournalException
import com.example.noswimmingserver.domain.reading_journal.facade.ReadingJournalFacade
import com.example.noswimmingserver.global.security.SecurityFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SubmitReadingJournalService(
    private val readingJournalFacade: ReadingJournalFacade,
    private val securityFacade: SecurityFacade,
) {

    @Transactional
    fun execute(readingJournalId: Long) {
        val readingJournal  = readingJournalFacade.getReadingJournalById(readingJournalId)

        val user = securityFacade.getCurrentUser()

        if(readingJournal.student.userId != user.id) {
            throw CannotSubmitReadingJournalException
        }

        readingJournal.submitJournal()
    }
}
package com.example.noswimmingserver.domain.reading_journal.service

import com.example.noswimmingserver.domain.reading_journal.exception.CannotUpdateReadingJournalException
import com.example.noswimmingserver.domain.reading_journal.facade.ReadingJournalFacade
import com.example.noswimmingserver.domain.reading_journal.presentation.dto.request.UpdateReadingJournalRequest
import com.example.noswimmingserver.global.security.SecurityFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UpdateReadingJournalService(
    private val securityFacade: SecurityFacade,
    private val readingJournalFacade: ReadingJournalFacade,
) {

    @Transactional
    fun execute(readingJournalId: Long, request: UpdateReadingJournalRequest) {
        val user = securityFacade.getCurrentUser()

        val readingJournal = readingJournalFacade.getReadingJournalById(readingJournalId)

        if (user != readingJournal.student) {
            throw CannotUpdateReadingJournalException
        }

        readingJournal.editReadingJournal(
            title = request.title,
            content = request.content,
        )
    }
}

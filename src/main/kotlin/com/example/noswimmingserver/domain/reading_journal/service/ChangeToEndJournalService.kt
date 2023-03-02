package com.example.noswimmingserver.domain.reading_journal.service

import com.example.noswimmingserver.domain.reading_journal.facade.ReadingJournalFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ChangeToEndJournalService(
    private val readingJournalFacade: ReadingJournalFacade,
) {

    @Transactional
    fun execute(readingJournalId: Long) {
        val readingJournal = readingJournalFacade.getReadingJournalById(readingJournalId)
        readingJournal.changeToEndJournal()
    }
}

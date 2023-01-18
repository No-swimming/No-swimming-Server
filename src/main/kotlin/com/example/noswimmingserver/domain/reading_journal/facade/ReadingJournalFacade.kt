package com.example.noswimmingserver.domain.reading_journal.facade

import com.example.noswimmingserver.domain.reading_journal.domain.ReadingJournal
import com.example.noswimmingserver.domain.reading_journal.domain.repository.ReadingJournalRepository
import com.example.noswimmingserver.domain.reading_journal.exception.ReadingJournalNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class ReadingJournalFacade(
    private val readingJournalRepository: ReadingJournalRepository,
) {

    fun getReadingJournalById(readingJournalId: Long): ReadingJournal {
        return readingJournalRepository.findByIdOrNull(readingJournalId)
            ?: throw ReadingJournalNotFoundException
    }
}
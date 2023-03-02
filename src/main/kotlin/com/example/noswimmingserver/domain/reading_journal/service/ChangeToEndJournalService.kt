package com.example.noswimmingserver.domain.reading_journal.service

import com.example.noswimmingserver.domain.reading_journal.exception.ReadingJournalNotFoundException
import com.example.noswimmingserver.domain.reading_journal.facade.ReadingJournalFacade
import com.example.noswimmingserver.domain.reading_journal.presentation.dto.request.ChangeToEndJournalRequest
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

    @Transactional
    fun execute(request: ChangeToEndJournalRequest) {
        val readingJournalList = readingJournalFacade.getReadingJournalListById(request.readingJournalIdList)

        request.readingJournalIdList.map {
            val readingJournal = readingJournalList.find { readingJournal -> readingJournal.id == it }
                ?: throw ReadingJournalNotFoundException

            readingJournal.changeToEndJournal()
        }
    }
}

package com.example.noswimmingserver.domain.reading_journal.service

import com.example.noswimmingserver.domain.reading_journal.domain.repository.ReadingJournalRepository
import com.example.noswimmingserver.domain.reading_journal.presentation.dto.response.QueryMyJournalElement
import com.example.noswimmingserver.domain.reading_journal.presentation.dto.response.QueryMyJournalList
import com.example.noswimmingserver.global.security.SecurityFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryMyJournalListService(
    private val securityFacade: SecurityFacade,
    private val readingJournalRepository: ReadingJournalRepository,
) {

    @Transactional(readOnly = true)
    fun execute(): QueryMyJournalList {
        val journalList = readingJournalRepository.queryReadingJournalListByUserId(securityFacade.getCurrentUser().id)

        val response = journalList.map {
            QueryMyJournalElement(
                bookId = it.bookId,
                bookNum = it.bookNum,
                title = it.title,
                recordReject = it.recordReject,
                readingJournalType = it.readingJournalType,
                readingJournalId = it.readingJournalId,
            )
        }

        return QueryMyJournalList(response)
    }
}

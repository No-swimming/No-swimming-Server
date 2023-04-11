package com.example.noswimmingserver.domain.reading_journal.presentation.dto.response

import com.example.noswimmingserver.domain.reading_journal.domain.ReadingJournalType

data class QueryMyJournalElement(
    val bookId: Long,
    val bookNum: Int,
    val title: String,
    val recordReject: Boolean,
    val readingJournalType: ReadingJournalType,
    val readingJournalId: Long,
)

package com.example.noswimmingserver.domain.reading_journal.presentation.dto.response

import com.example.noswimmingserver.domain.reading_journal.domain.ReadingJournalType

data class QueryMyJournalElement(
    val bookId: Long,
    val bookNum: Int,
    val recordReject: Boolean,
    val readingJournalType: ReadingJournalType,
)

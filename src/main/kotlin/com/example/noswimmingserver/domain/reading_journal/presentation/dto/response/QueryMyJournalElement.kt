package com.example.noswimmingserver.domain.reading_journal.presentation.dto.response

data class QueryMyJournalElement(
    val bookId: Long,
    val bookNum: Int,
    val recordReject: Boolean,
    val isRejected: Boolean,
)

package com.example.noswimmingserver.domain.reading_journal.presentation.dto.response

data class QueryJournalDetailResponse(
    val bookId: Long,
    val bookNum: Int,
    val title: String,
    val content: String,
    val recordReject: Boolean,
    val isRejected: Boolean,
    val teacherName: String,
    val teacherSubject: String,
)

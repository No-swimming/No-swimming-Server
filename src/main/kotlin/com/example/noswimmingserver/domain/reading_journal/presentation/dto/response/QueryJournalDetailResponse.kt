package com.example.noswimmingserver.domain.reading_journal.presentation.dto.response

import com.example.noswimmingserver.domain.reading_journal.domain.ReadingJournalType

data class QueryJournalDetailResponse(
    val bookId: Long,
    val bookNum: Int,
    val title: String,
    val content: String,
    val recordReject: Boolean,
    val readingJournalType: ReadingJournalType,
    val teacherName: String,
    val teacherSubject: String?,
)

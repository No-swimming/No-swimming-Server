package com.example.noswimmingserver.domain.reading_journal.domain.repository.vo

import com.example.noswimmingserver.domain.reading_journal.domain.ReadingJournalType
import com.querydsl.core.annotations.QueryProjection
import java.time.LocalDateTime

class QueryJournalVO @QueryProjection constructor(
    val bookId: Long,
    val bookNum: Int,
    val title: String,
    val recordReject: Boolean,
    val readingJournalType: ReadingJournalType,
    val readingJournalId: Long,
    val userId: Long,
    val createdAt: LocalDateTime,
)

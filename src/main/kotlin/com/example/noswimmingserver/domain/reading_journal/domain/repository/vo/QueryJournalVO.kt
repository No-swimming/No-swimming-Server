package com.example.noswimmingserver.domain.reading_journal.domain.repository.vo

import com.querydsl.core.annotations.QueryProjection

class QueryJournalVO @QueryProjection constructor(
    val bookId: Long,
    val bookNum: Int,
    val recordReject: Boolean,
    val isRejected: Boolean,
)
package com.example.noswimmingserver.domain.reading_journal.domain.repository

import com.example.noswimmingserver.domain.reading_journal.domain.repository.vo.QueryJournalVO

interface CustomReadingJournalRepository {

    fun queryMyReadingJournalList(userId: Long): List<QueryJournalVO>

    fun countMyReadingJournal(userId: Long): Long
}

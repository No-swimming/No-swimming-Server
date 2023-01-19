package com.example.noswimmingserver.domain.reading_journal.domain.repository

import com.example.noswimmingserver.domain.reading_journal.domain.ReadingJournal
import org.springframework.data.repository.CrudRepository

interface ReadingJournalRepository : CrudRepository<ReadingJournal, Long>, CustomReadingJournalRepository {

}
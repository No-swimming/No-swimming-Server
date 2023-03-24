package com.example.noswimmingserver.domain.teacher.presentation.dto.response

import com.example.noswimmingserver.domain.reading_journal.domain.ReadingJournalType

data class QueryStudentJournalList(
    val journalList: List<StudentJournalElement>,
) {
    data class StudentJournalElement(
        val bookId: Long,
        val bookNum: Int,
        val title: String,
        val recordReject: Boolean,
        val readingJournalType: ReadingJournalType,
    )
}

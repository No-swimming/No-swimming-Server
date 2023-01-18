package com.example.noswimmingserver.domain.reading_journal.exception.code

import com.example.noswimmingserver.global.error.response.ErrorProperty

enum class ReadingJournalErrorCode(
    override val status: Int,
    override val message: String
) : ErrorProperty {

    READING_JOURNAL_NOT_FOUND(404, "Reading Journal Not Found ")
}
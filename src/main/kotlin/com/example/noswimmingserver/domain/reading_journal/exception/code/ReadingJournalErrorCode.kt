package com.example.noswimmingserver.domain.reading_journal.exception.code

import com.example.noswimmingserver.global.error.response.ErrorProperty

enum class ReadingJournalErrorCode(
    override val status: Int,
    override val message: String
) : ErrorProperty {

    CANNOT_UPDATE_READING_JOURNAL(401, "Cannot Update Reading Journal"),
    CANNOT_DELETE_READING_JOURNAL(401, "Cannot Delete Reading Journal"),
    CANNOT_SUBMIT_READING_JOURNAL(401, "Cannot Submit Reading Journal"),

    READING_JOURNAL_NOT_FOUND(404, "Reading Journal Not Found ")
}
package com.example.noswimmingserver.domain.reading_journal.exception

import com.example.noswimmingserver.domain.reading_journal.exception.code.ReadingJournalErrorCode
import com.example.noswimmingserver.global.error.CustomException

object CannotDeleteReadingJournalException : CustomException(
    ReadingJournalErrorCode.CANNOT_DELETE_READING_JOURNAL
)
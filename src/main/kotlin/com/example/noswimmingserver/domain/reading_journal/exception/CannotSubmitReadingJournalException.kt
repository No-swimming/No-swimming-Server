package com.example.noswimmingserver.domain.reading_journal.exception

import com.example.noswimmingserver.domain.reading_journal.exception.code.ReadingJournalErrorCode
import com.example.noswimmingserver.global.error.CustomException

object CannotSubmitReadingJournalException : CustomException(
    ReadingJournalErrorCode.CANNOT_SUBMIT_READING_JOURNAL
)

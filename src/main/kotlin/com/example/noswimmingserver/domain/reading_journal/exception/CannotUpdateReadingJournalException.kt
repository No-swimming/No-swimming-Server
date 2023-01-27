package com.example.noswimmingserver.domain.reading_journal.exception

import com.example.noswimmingserver.domain.reading_journal.exception.code.ReadingJournalErrorCode
import com.example.noswimmingserver.global.error.CustomException

object CannotUpdateReadingJournalException : CustomException(
    ReadingJournalErrorCode.CANNOT_UPDATE_READING_JOURNAL,
)

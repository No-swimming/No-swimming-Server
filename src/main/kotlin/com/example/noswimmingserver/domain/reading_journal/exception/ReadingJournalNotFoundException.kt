package com.example.noswimmingserver.domain.reading_journal.exception

import com.example.noswimmingserver.domain.reading_journal.exception.code.ReadingJournalErrorCode
import com.example.noswimmingserver.global.error.CustomException

object ReadingJournalNotFoundException : CustomException(
    ReadingJournalErrorCode.READING_JOURNAL_NOT_FOUND
)
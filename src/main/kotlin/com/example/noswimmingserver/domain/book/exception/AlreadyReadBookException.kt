package com.example.noswimmingserver.domain.book.exception

import com.example.noswimmingserver.domain.book.exception.code.BookErrorCode
import com.example.noswimmingserver.global.error.CustomException

object AlreadyReadBookException : CustomException(
    BookErrorCode.ALREADY_READ_BOOK,
)

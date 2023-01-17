package com.example.noswimmingserver.domain.book.exception

import com.example.noswimmingserver.domain.book.exception.code.BookErrorCode
import com.example.noswimmingserver.global.error.CustomException

object BookNotFoundException : CustomException(
    BookErrorCode.BOOK_NOT_FOUND
)
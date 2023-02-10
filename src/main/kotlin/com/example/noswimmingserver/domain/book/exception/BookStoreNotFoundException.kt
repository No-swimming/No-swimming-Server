package com.example.noswimmingserver.domain.book.exception

import com.example.noswimmingserver.domain.book.exception.code.BookErrorCode
import com.example.noswimmingserver.global.error.CustomException

object BookStoreNotFoundException : CustomException(
    BookErrorCode.BOOKSTORE_NOT_FOUND,
)

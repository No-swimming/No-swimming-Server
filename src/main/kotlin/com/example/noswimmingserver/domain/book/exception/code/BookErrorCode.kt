package com.example.noswimmingserver.domain.book.exception.code

import com.example.noswimmingserver.global.error.response.ErrorProperty

enum class BookErrorCode(
    override val status: Int,
    override val message: String
) : ErrorProperty {

    BOOK_NOT_FOUND(404, "Book Not Found"),
    BOOKSTORE_NOT_FOUND(404, "BookStore Not Found"),

    ALREADY_READ_BOOK(409, "Already Read Book"),
    ALREADY_LIKE_BOOK(409, "Already Like Book"),
}
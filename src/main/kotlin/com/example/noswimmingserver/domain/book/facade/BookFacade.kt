package com.example.noswimmingserver.domain.book.facade

import com.example.noswimmingserver.domain.book.domain.Book
import com.example.noswimmingserver.domain.book.domain.repository.BookRepository
import com.example.noswimmingserver.domain.book.exception.BookNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class BookFacade(
    private val bookRepository: BookRepository
) {

    fun getBookById(bookId: Long): Book {
        return bookRepository.findByIdOrNull(bookId)
            ?: throw BookNotFoundException
    }
}
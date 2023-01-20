package com.example.noswimmingserver.domain.book.service

import com.example.noswimmingserver.domain.book.domain.Book
import com.example.noswimmingserver.domain.book.domain.MyBook
import com.example.noswimmingserver.domain.book.domain.repository.MyBookRepository
import com.example.noswimmingserver.domain.book.exception.AlreadyReadBookException
import com.example.noswimmingserver.domain.book.facade.BookFacade
import com.example.noswimmingserver.domain.book.presentation.dto.response.ReadBookResponse
import com.example.noswimmingserver.domain.common_user.domain.User
import com.example.noswimmingserver.global.security.SecurityFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BookReadService(
    private val bookFacade: BookFacade,
    private val securityFacade: SecurityFacade,
    private val myBookRepository: MyBookRepository,
) {

    @Transactional
    fun execute(bookId: Long): ReadBookResponse {
        val book = bookFacade.getBookById(bookId)

        val user = securityFacade.getCurrentUser()

        if (checkIsRead(book, user)) {
            throw AlreadyReadBookException
        }

        myBookRepository.save(
            MyBook(
                book = book,
                user = user,
            )
        )
        return ReadBookResponse(isRead = true)
    }

    private fun checkIsRead(book: Book, user: User) = myBookRepository.existsByBookAndUser(book, user)

}
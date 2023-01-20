package com.example.noswimmingserver.domain.book.service

import com.example.noswimmingserver.domain.book.domain.Book
import com.example.noswimmingserver.domain.book.domain.BookLike
import com.example.noswimmingserver.domain.book.domain.repository.BookLikeRepository
import com.example.noswimmingserver.domain.book.exception.AlreadyLikeBookException
import com.example.noswimmingserver.domain.book.facade.BookFacade
import com.example.noswimmingserver.domain.book.presentation.dto.response.AddBookLikeResponse
import com.example.noswimmingserver.domain.common_user.domain.User
import com.example.noswimmingserver.global.security.SecurityFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AddBookLikeService(
    private val bookLikeRepository: BookLikeRepository,
    private val bookFacade: BookFacade,
    private val securityFacade: SecurityFacade,
) {

    @Transactional
    fun execute(bookId: Long): AddBookLikeResponse {
        val user = securityFacade.getCurrentUser()

        val book = bookFacade.getBookById(bookId)

        if (checkExistLike(user, book)) {
            throw AlreadyLikeBookException
        }

        bookLikeRepository.save(
            BookLike(
                user = user,
                book = book,
            ),
        )

        return AddBookLikeResponse(
            likeCount = queryBookLikeCount(user, book),
            liked = checkExistLike(user, book),
        )
    }

    private fun queryBookLikeCount(user: User, book: Book) = bookLikeRepository.countByUserAndBook(user, book).toInt()

    private fun checkExistLike(user: User, book: Book) = bookLikeRepository.existsByUserAndBook(user, book)
}

package com.example.noswimmingserver.domain.book.service

import com.example.noswimmingserver.domain.book.domain.repository.BookLikeRepository
import com.example.noswimmingserver.domain.book.domain.repository.BookRepository
import com.example.noswimmingserver.domain.book.exception.BookStoreNotFoundException
import com.example.noswimmingserver.domain.book.presentation.dto.response.QueryMyBookStoreList
import com.example.noswimmingserver.domain.book.presentation.dto.response.QueryMyBookStoreList.BookStoreElement
import com.example.noswimmingserver.global.security.SecurityFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryMyBookStoreService(
    private val bookRepository: BookRepository,
    private val bookLikeRepository: BookLikeRepository,
    private val securityFacade: SecurityFacade,
) {

    companion object {
        const val IS_LIKE = "is_like"
        const val IS_READ = "is_read"
    }

    @Transactional(readOnly = true)
    fun execute(bookStoreType: String): QueryMyBookStoreList {
        val user = securityFacade.getCurrentUser()

        val bookList = when (bookStoreType) {
            IS_LIKE -> bookRepository.queryMyLikedBookList(user)
            IS_READ -> bookRepository.queryMyReadBookList(user)
            else -> throw BookStoreNotFoundException
        }

        val response = bookList.map {
            BookStoreElement(
                bookId = it.id,
                bookNum = it.num,
                isRead = it.isRead,
                isLiked = bookLikeRepository.existsByUserAndBook(user, it),
            )
        }

        return QueryMyBookStoreList(response)
    }
}

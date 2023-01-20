package com.example.noswimmingserver.domain.book.domain.repository

import com.example.noswimmingserver.domain.book.domain.Book
import com.example.noswimmingserver.domain.book.domain.BookLike
import com.example.noswimmingserver.domain.common_user.domain.User
import org.springframework.data.repository.CrudRepository

interface BookLikeRepository : CrudRepository<BookLike, Long> {

    fun existsByUserAndBook(user: User, book: Book): Boolean

    fun countByUserAndBook(user: User, book: Book): Long
}

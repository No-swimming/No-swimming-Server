package com.example.noswimmingserver.domain.book.domain.repository

import com.example.noswimmingserver.domain.book.domain.Book
import com.example.noswimmingserver.domain.book.domain.MyBook
import com.example.noswimmingserver.domain.common_user.domain.User
import org.springframework.data.repository.CrudRepository

interface MyBookRepository : CrudRepository<MyBook, Long> {

    fun existsByBookAndUser(book: Book, user: User): Boolean

}
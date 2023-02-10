package com.example.noswimmingserver.domain.book.domain.repository

import com.example.noswimmingserver.domain.book.domain.Book
import com.example.noswimmingserver.domain.common_user.domain.User

interface CustomBookRepository {

    fun queryMyLikedBookList(user: User): List<Book>

    fun queryMyReadBookList(user: User): List<Book>
}
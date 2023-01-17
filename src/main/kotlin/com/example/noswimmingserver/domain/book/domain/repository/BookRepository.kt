package com.example.noswimmingserver.domain.book.domain.repository

import com.example.noswimmingserver.domain.book.domain.Book
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<Book, Long> {
}
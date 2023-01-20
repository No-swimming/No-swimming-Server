package com.example.noswimmingserver.domain.book.presentation

import com.example.noswimmingserver.domain.book.presentation.dto.response.AddBookLikeResponse
import com.example.noswimmingserver.domain.book.presentation.dto.response.ReadBookResponse
import com.example.noswimmingserver.domain.book.service.AddBookLikeService
import com.example.noswimmingserver.domain.book.service.BookReadService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequestMapping("/book")
@RestController
class BookController(
    private val bookReadService: BookReadService,
    private val addBookLikeService: AddBookLikeService,
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{book-id}")
    fun bookRead(@PathVariable("book-id") bookId: Long): ReadBookResponse {
        return bookReadService.execute(bookId)
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/like/{book-id}")
    fun addLike(@PathVariable("book-id") bookId: Long): AddBookLikeResponse {
        return addBookLikeService.execute(bookId)
    }
}

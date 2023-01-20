package com.example.noswimmingserver.domain.book.presentation

import com.example.noswimmingserver.domain.book.presentation.dto.response.ReadBookResponse
import com.example.noswimmingserver.domain.book.service.BookReadService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequestMapping("/book")
@RestController
class BookController(
    private val bookReadService: BookReadService,
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{book-id}")
    fun bookRead(@PathVariable("book-id") bookId: Long): ReadBookResponse {
        return bookReadService.execute(bookId)
    }
}

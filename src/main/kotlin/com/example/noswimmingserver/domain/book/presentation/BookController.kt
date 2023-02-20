package com.example.noswimmingserver.domain.book.presentation

import com.example.noswimmingserver.domain.book.domain.type.BookStoreType
import com.example.noswimmingserver.domain.book.presentation.dto.response.AddBookLikeResponse
import com.example.noswimmingserver.domain.book.presentation.dto.response.QueryMyBookStoreList
import com.example.noswimmingserver.domain.book.presentation.dto.response.ReadBookResponse
import com.example.noswimmingserver.domain.book.service.AddBookLikeService
import com.example.noswimmingserver.domain.book.service.BookReadService
import com.example.noswimmingserver.domain.book.service.QueryMyBookStoreService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequestMapping("/book")
@RestController
class BookController(
    private val bookReadService: BookReadService,
    private val addBookLikeService: AddBookLikeService,
    private val queryMyBookStoreService: QueryMyBookStoreService,
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

    @GetMapping
    fun getMyBookStore(@RequestParam bookStoreType: String): QueryMyBookStoreList {
        return queryMyBookStoreService.execute(bookStoreType)
    }
}

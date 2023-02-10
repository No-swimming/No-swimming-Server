package com.example.noswimmingserver.domain.book.presentation.dto.response

data class QueryMyBookStoreList(
    val bookList: List<BookStoreElement>,
) {
    data class BookStoreElement(
        val bookId: Long,
        val bookNum: Int,
        val isRead: Boolean,
        val isLiked: Boolean,
    )
}

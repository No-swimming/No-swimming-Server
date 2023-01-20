package com.example.noswimmingserver.domain.book.presentation.dto.response

data class AddBookLikeResponse(
    val likeCount: Int,
    val liked: Boolean,
)

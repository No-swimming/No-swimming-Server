package com.example.noswimmingserver.domain.student.presentation.dto.response

data class QueryMyInfoResponse(
    val email: String,
    val name: String,
    val grade: Int,
    val classNum: Int,
    val number: Int,
    val countRejectBook: Int,
    val countReadBook: Int,
    val myRank: Int,
)

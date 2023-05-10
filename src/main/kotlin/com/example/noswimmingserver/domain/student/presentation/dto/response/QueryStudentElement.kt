package com.example.noswimmingserver.domain.student.presentation.dto.response

data class QueryStudentElement(
    val userId: Long,
    val grade: Int,
    val classNum: Int,
    val number: Int,
    val name: String,
)

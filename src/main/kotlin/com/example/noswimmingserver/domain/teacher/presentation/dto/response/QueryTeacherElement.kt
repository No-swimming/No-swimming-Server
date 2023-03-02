package com.example.noswimmingserver.domain.teacher.presentation.dto.response

data class QueryTeacherElement(
    val teacherId: Long,
    val teacherName: String,
    val subject: String?,
)

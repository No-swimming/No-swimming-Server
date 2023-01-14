package com.example.noswimmingserver.domain.student.exception.code

import com.example.noswimmingserver.global.error.response.ErrorProperty

enum class StudentErrorCode(
    override val status: Int,
    override val message: String
) : ErrorProperty {

    STUDENT_NOT_FOUND(404, "Student Not Found"),
}
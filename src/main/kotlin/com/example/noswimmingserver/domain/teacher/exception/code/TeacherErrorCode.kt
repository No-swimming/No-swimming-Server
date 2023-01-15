package com.example.noswimmingserver.domain.teacher.exception.code

import com.example.noswimmingserver.global.error.response.ErrorProperty

enum class TeacherErrorCode(
    override val status: Int,
    override val message: String
) : ErrorProperty {

    TEACHER_NOT_FOUND(404, "Teacher Not Found"),
}
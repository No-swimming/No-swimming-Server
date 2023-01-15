package com.example.noswimmingserver.domain.teacher.exception.code

import com.example.noswimmingserver.global.error.response.ErrorProperty

enum class TeacherErrorCode(
    override val status: Int,
    override val message: String
) : ErrorProperty {

    PASSWORD_MIS_MATCH(401, "Password Mis Match"),

    TEACHER_NOT_FOUND(404, "Teacher Not Found"),
}
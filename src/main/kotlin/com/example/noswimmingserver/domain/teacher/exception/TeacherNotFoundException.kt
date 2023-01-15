package com.example.noswimmingserver.domain.teacher.exception

import com.example.noswimmingserver.domain.teacher.exception.code.TeacherErrorCode
import com.example.noswimmingserver.global.error.CustomException

object TeacherNotFoundException : CustomException(
    TeacherErrorCode.TEACHER_NOT_FOUND
)
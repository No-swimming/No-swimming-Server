package com.example.noswimmingserver.domain.teacher.exception

import com.example.noswimmingserver.domain.teacher.exception.code.TeacherErrorCode
import com.example.noswimmingserver.global.error.CustomException

object PasswordMisMatchException : CustomException(
    TeacherErrorCode.PASSWORD_MIS_MATCH
)
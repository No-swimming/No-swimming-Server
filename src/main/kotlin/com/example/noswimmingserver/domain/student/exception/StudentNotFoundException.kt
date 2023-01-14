package com.example.noswimmingserver.domain.student.exception

import com.example.noswimmingserver.domain.student.exception.code.StudentErrorCode
import com.example.noswimmingserver.global.error.CustomException

object StudentNotFoundException : CustomException(
    StudentErrorCode.STUDENT_NOT_FOUND
)
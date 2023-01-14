package com.example.noswimmingserver.domain.common_user.exception.code

import com.example.noswimmingserver.global.error.CustomException

object InvalidEmailException : CustomException(
    UserErrorCode.INVALID_EMAIL
)
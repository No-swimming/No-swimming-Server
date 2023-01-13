package com.example.noswimmingserver.global.exception

import com.example.noswimmingserver.global.error.CustomException
import com.example.noswimmingserver.global.error.GlobalErrorCode

object ExpiredTokenException : CustomException(
    GlobalErrorCode.EXPIRED_TOKEN
)
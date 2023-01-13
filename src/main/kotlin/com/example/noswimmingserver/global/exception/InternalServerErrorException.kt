package com.example.noswimmingserver.global.exception

import com.example.noswimmingserver.global.error.CustomException
import com.example.noswimmingserver.global.error.GlobalErrorCode

object InternalServerErrorException : CustomException(
    GlobalErrorCode.INTERNAL_SERVER_ERROR
)
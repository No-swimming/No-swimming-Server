package com.example.noswimmingserver.infra.feign.exception

import com.example.noswimmingserver.global.error.CustomException
import com.example.noswimmingserver.global.error.GlobalErrorCode

object FeignForbiddenException : CustomException(
    GlobalErrorCode.FEIGN_FORBIDDEN
)
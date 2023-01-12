package com.example.noswimmingserver.infra.feign.exception

import com.example.noswimmingserver.global.error.CustomException
import com.example.noswimmingserver.global.error.GlobalErrorCode

object FeignExpiredTokenException : CustomException(
    GlobalErrorCode.FEIGN_EXPIRED_TOKEN
)
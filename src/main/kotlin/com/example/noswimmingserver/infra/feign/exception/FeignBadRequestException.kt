package com.example.noswimmingserver.infra.feign.exception

import com.example.noswimmingserver.global.error.CustomException
import com.example.noswimmingserver.global.error.GlobalErrorCode

object FeignBadRequestException : CustomException(
    GlobalErrorCode.FEIGN_BAD_REQUEST
)
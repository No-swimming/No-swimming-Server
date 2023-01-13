package com.example.noswimmingserver.domain.common_user.exception

import com.example.noswimmingserver.domain.common_user.exception.code.UserErrorCode
import com.example.noswimmingserver.global.error.CustomException

object UserNotFoundException : CustomException(
    UserErrorCode.USER_NOT_FOUND
)
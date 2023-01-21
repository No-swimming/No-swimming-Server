package com.example.noswimmingserver.domain.rank.exception

import com.example.noswimmingserver.domain.rank.exception.code.UserRankErrorCode
import com.example.noswimmingserver.global.error.CustomException

object UserRankNotFoundException : CustomException(
    UserRankErrorCode.USER_RANK_NOT_FOUND
)
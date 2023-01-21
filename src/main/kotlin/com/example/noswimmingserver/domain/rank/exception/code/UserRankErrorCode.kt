package com.example.noswimmingserver.domain.rank.exception.code

import com.example.noswimmingserver.global.error.response.ErrorProperty

enum class UserRankErrorCode(
    override val status: Int,
    override val message: String,
) : ErrorProperty {

    USER_RANK_NOT_FOUND(404, "User Rank Not Found"),
}

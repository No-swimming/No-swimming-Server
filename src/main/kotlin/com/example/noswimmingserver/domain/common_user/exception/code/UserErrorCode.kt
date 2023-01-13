package com.example.noswimmingserver.domain.common_user.exception.code

import com.example.noswimmingserver.global.error.response.ErrorProperty

enum class UserErrorCode(
    override val status: Int,
    override val message: String
) : ErrorProperty {

    USER_NOT_FOUND(404, "User Not Found"),
}
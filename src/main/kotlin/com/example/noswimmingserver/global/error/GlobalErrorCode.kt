package com.example.noswimmingserver.global.error

import com.example.noswimmingserver.global.error.response.ErrorProperty

enum class GlobalErrorCode(
    override val status: Int,
    override val message: String
) : ErrorProperty {

    FEIGN_BAD_REQUEST(400, "Feign Bad Request"),

    FEIGN_UN_AUTHORIZED(401, "Feign Un Authorized"),

    FEIGN_FORBIDDEN(403, "Feign ForBidden"),

    FEIGN_EXPIRED_TOKEN(419, "Feign Expired Token"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),

}
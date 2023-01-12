package com.example.noswimmingserver.global.error.response

import com.example.noswimmingserver.global.error.CustomException

class ErrorResponse(
    val status: Int,
    val message: String
) {

    companion object {
        fun of(e: CustomException): ErrorResponse {
            return ErrorResponse(
                status = e.status,
                message = e.message
            )
        }
    }

}
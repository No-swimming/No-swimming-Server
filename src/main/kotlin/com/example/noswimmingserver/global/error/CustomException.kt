package com.example.noswimmingserver.global.error

import com.example.noswimmingserver.global.error.response.ErrorProperty

open class CustomException(private val error: ErrorProperty) : RuntimeException() {

    val status: Int
        get() = error.status

    override val message: String
        get() = error.message

}
package com.example.noswimmingserver.global.error

import com.example.noswimmingserver.global.error.response.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(CustomException::class)
    fun customExceptionHandling(e: CustomException): ResponseEntity<ErrorResponse> {
        return ResponseEntity(
            ErrorResponse.of(e),
            HttpStatus.valueOf(e.status)
        )
    }

}
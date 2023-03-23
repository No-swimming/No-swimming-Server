package com.example.noswimmingserver.domain.student.presentation.dto.request

import javax.validation.constraints.NotBlank

data class StudentSignInRequest(

    @field:NotBlank
    val email: String,

    @field:NotBlank
    val password: String
)

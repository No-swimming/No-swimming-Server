package com.example.noswimmingserver.domain.teacher.presentation.dto.request

import javax.validation.constraints.NotBlank

data class TeacherSignInRequest(
    @field:NotBlank
    val email: String,

    @field:NotBlank
    val password: String,

    @field:NotBlank
    val deviceToken: String,
)

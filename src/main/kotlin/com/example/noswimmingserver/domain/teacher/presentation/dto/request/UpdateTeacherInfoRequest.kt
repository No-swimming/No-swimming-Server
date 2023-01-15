package com.example.noswimmingserver.domain.teacher.presentation.dto.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class UpdateTeacherInfoRequest(

    @field:NotBlank
    @Size(max = 5)
    val name: String,

    @field:NotBlank
    @Size(max = 20)
    val subject: String,
)

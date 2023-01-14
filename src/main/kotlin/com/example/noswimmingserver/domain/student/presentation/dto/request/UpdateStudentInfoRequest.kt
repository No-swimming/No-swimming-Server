package com.example.noswimmingserver.domain.student.presentation.dto.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class UpdateStudentInfoRequest(

    @field:NotBlank
    @Size(max = 5)
    val name: String,

    @field:NotNull
    val grade: Int,

    @field:NotNull
    val classNum: Int,

    @field:NotNull
    val number: Int,
)

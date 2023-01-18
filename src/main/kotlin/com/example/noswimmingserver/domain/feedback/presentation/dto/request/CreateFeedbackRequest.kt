package com.example.noswimmingserver.domain.feedback.presentation.dto.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class CreateFeedbackRequest(
    @field:NotBlank
    @Size(max = 500)
    val content: String,
)

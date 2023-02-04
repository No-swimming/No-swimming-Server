package com.example.noswimmingserver.domain.feedback.presentation.dto.response

import java.time.LocalDateTime

data class QueryFeedbackDetailResponse(
    val feedbackId: Long,

    val content: String,

    val teacherName: String,

    val createdAt: LocalDateTime,
)

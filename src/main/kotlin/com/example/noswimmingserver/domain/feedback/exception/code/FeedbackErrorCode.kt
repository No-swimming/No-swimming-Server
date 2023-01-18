package com.example.noswimmingserver.domain.feedback.exception.code

import com.example.noswimmingserver.global.error.response.ErrorProperty

enum class FeedbackErrorCode(
    override val status: Int,
    override val message: String
) : ErrorProperty {

    FEEDBACK_NOT_FOUND(404, "Feedback Not Found"),
}
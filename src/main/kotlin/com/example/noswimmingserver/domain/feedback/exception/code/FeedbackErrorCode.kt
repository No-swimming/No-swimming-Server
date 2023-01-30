package com.example.noswimmingserver.domain.feedback.exception.code

import com.example.noswimmingserver.global.error.response.ErrorProperty

enum class FeedbackErrorCode(
    override val status: Int,
    override val message: String
) : ErrorProperty {

    CANNOT_UPDATE_FEEDBACK(401, "Cannot Update Feedback"),
    CANNOT_DELETE_FEEDBACK(401, "Cannot Delete Feedback"),

    FEEDBACK_NOT_FOUND(404, "Feedback Not Found"),
}
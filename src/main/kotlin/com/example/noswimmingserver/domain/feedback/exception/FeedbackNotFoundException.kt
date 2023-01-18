package com.example.noswimmingserver.domain.feedback.exception

import com.example.noswimmingserver.domain.feedback.exception.code.FeedbackErrorCode
import com.example.noswimmingserver.global.error.CustomException

object FeedbackNotFoundException : CustomException(
    FeedbackErrorCode.FEEDBACK_NOT_FOUND
)
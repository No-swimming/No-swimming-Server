package com.example.noswimmingserver.domain.feedback.exception

import com.example.noswimmingserver.domain.feedback.exception.code.FeedbackErrorCode
import com.example.noswimmingserver.global.error.CustomException

object CannotUpdateFeedbackException : CustomException(
    FeedbackErrorCode.CANNOT_UPDATE_FEEDBACK,
)

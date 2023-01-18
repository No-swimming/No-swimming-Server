package com.example.noswimmingserver.domain.feedback.facade

import com.example.noswimmingserver.domain.feedback.domain.Feedback
import com.example.noswimmingserver.domain.feedback.domain.repository.FeedbackRepository
import com.example.noswimmingserver.domain.feedback.exception.FeedbackNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class FeedbackFacade(
    private val feedbackRepository: FeedbackRepository,
) {

    fun getFeedbackById(feedbackId: Long): Feedback {
        return feedbackRepository.findByIdOrNull(feedbackId)
            ?: throw FeedbackNotFoundException
    }
}
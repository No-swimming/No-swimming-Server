package com.example.noswimmingserver.domain.feedback.domain.repository

import com.example.noswimmingserver.domain.feedback.domain.Feedback
import org.springframework.data.repository.CrudRepository

interface FeedbackRepository : CrudRepository<Feedback, Long> {
}
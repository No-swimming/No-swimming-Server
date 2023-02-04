package com.example.noswimmingserver.domain.feedback.service

import com.example.noswimmingserver.domain.feedback.domain.Feedback
import com.example.noswimmingserver.domain.feedback.domain.repository.FeedbackRepository
import com.example.noswimmingserver.domain.feedback.exception.CannotDeleteFeedbackException
import com.example.noswimmingserver.domain.feedback.exception.CannotUpdateFeedbackException
import com.example.noswimmingserver.domain.feedback.facade.FeedbackFacade
import com.example.noswimmingserver.domain.feedback.presentation.dto.request.CreateFeedbackRequest
import com.example.noswimmingserver.domain.feedback.presentation.dto.request.UpdateFeedbackRequest
import com.example.noswimmingserver.domain.feedback.presentation.dto.response.QueryFeedbackDetailResponse
import com.example.noswimmingserver.domain.reading_journal.facade.ReadingJournalFacade
import com.example.noswimmingserver.domain.teacher.facade.TeacherFacade
import com.example.noswimmingserver.global.security.SecurityFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class FeedbackService(
    private val securityFacade: SecurityFacade,
    private val teacherFacade: TeacherFacade,
    private val readingJournalFacade: ReadingJournalFacade,
    private val feedbackFacade: FeedbackFacade,
    private val feedbackRepository: FeedbackRepository,
) {

    @Transactional
    fun execute(readingJournalId: Long, request: CreateFeedbackRequest) {
        val user = securityFacade.getCurrentUser()

        val teacher = teacherFacade.getTeacherById(user.id)

        val readingJournal = readingJournalFacade.getReadingJournalById(readingJournalId)

        feedbackRepository.save(
            Feedback(
                createdAt = LocalDateTime.now(),
                readingJournal = readingJournal,
                teacher = teacher,
                content = request.content
            )
        )
    }

    @Transactional
    fun execute(feedbackId: Long, request: UpdateFeedbackRequest) {
        val user = securityFacade.getCurrentUser()

        val feedback = feedbackFacade.getFeedbackById(feedbackId)

        if (user != feedback.teacher) {
            throw CannotUpdateFeedbackException
        }

        feedback.editContent(content = request.content)
    }

    @Transactional
    fun execute(feedbackId: Long) {
        val user = securityFacade.getCurrentUser()

        val feedback = feedbackFacade.getFeedbackById(feedbackId)

        if (user != feedback.teacher) {
            throw CannotDeleteFeedbackException
        }

        feedbackRepository.delete(feedback)
    }

    @Transactional(readOnly = true)
    fun queryFeedbackDetail(feedbackId: Long): QueryFeedbackDetailResponse {
        val feedback = feedbackFacade.getFeedbackById(feedbackId)

        return QueryFeedbackDetailResponse(
            feedbackId = feedback.id,
            content = feedback.content,
            teacherName = feedback.teacher.queryTeacherName(),
            createdAt = feedback.createdAt
        )
    }
}

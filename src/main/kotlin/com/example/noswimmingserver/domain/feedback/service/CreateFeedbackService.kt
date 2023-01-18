package com.example.noswimmingserver.domain.feedback.service

import com.example.noswimmingserver.domain.feedback.domain.Feedback
import com.example.noswimmingserver.domain.feedback.domain.repository.FeedbackRepository
import com.example.noswimmingserver.domain.feedback.presentation.dto.request.CreateFeedbackRequest
import com.example.noswimmingserver.domain.reading_journal.facade.ReadingJournalFacade
import com.example.noswimmingserver.domain.teacher.facade.TeacherFacade
import com.example.noswimmingserver.global.security.SecurityFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class CreateFeedbackService(
    private val securityFacade: SecurityFacade,
    private val teacherFacade: TeacherFacade,
    private val readingJournalFacade: ReadingJournalFacade,
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
}
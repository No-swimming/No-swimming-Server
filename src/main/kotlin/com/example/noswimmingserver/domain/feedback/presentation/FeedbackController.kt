package com.example.noswimmingserver.domain.feedback.presentation

import com.example.noswimmingserver.domain.feedback.presentation.dto.request.CreateFeedbackRequest
import com.example.noswimmingserver.domain.feedback.presentation.dto.request.UpdateFeedbackRequest
import com.example.noswimmingserver.domain.feedback.service.FeedbackService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RequestMapping("/feedback")
@RestController
class FeedbackController(
    private val feedbackService: FeedbackService,
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{reading-journal-id}")
    fun createFeedback(
        @PathVariable("reading-journal-id") readingJournalId: Long,
        @RequestBody @Valid request: CreateFeedbackRequest,
    ) {
        feedbackService.execute(readingJournalId, request)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{feedback-id}")
    fun editFeedback(
        @PathVariable("feedback-id") feedbackId: Long,
        @RequestBody @Valid request: UpdateFeedbackRequest,
    ) {
        feedbackService.execute(feedbackId, request)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feedback-id}")
    fun deleteFeedback(
        @PathVariable("feedback-id") feedbackId: Long,
    ) {
        feedbackService.execute(feedbackId)
    }
}

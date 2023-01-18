package com.example.noswimmingserver.domain.feedback.presentation

import com.example.noswimmingserver.domain.feedback.presentation.dto.request.CreateFeedbackRequest
import com.example.noswimmingserver.domain.feedback.service.CreateFeedbackService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RequestMapping("/feedback")
@RestController
class FeedbackController(
    private val createFeedbackService: CreateFeedbackService,
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{reading-journal-id}")
    fun createFeedback(
        @PathVariable("reading-journal-id") readingJournalId: Long,
        @RequestBody @Valid request: CreateFeedbackRequest
    ) {
        createFeedbackService.execute(readingJournalId, request)
    }
}
package com.example.noswimmingserver.domain.reading_journal.presentation

import com.example.noswimmingserver.domain.reading_journal.presentation.dto.request.CreateReadingJournalRequest
import com.example.noswimmingserver.domain.reading_journal.service.CreateReadingJournalService
import com.example.noswimmingserver.domain.reading_journal.service.DeleteReadingJournalService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RequestMapping("/journal")
@RestController
class ReadingJournalController(
    private val createReadingJournalService: CreateReadingJournalService,
    private val deleteReadingJournalService: DeleteReadingJournalService,
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{book-id}")
    fun createReadingJournal(
        @PathVariable("book-id") bookId: Long,
        @RequestBody @Valid request: CreateReadingJournalRequest
    ) {
        createReadingJournalService.execute(bookId, request)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{reading-journal-id}")
    fun deleteReadingJournal(
        @PathVariable("reading-journal-id")
        readingJournalId: Long
    ) {
        deleteReadingJournalService.execute(readingJournalId)
    }
}
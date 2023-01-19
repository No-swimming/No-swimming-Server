package com.example.noswimmingserver.domain.reading_journal.presentation

import com.example.noswimmingserver.domain.reading_journal.presentation.dto.request.CreateReadingJournalRequest
import com.example.noswimmingserver.domain.reading_journal.presentation.dto.response.QueryJournalDetailResponse
import com.example.noswimmingserver.domain.reading_journal.presentation.dto.response.QueryMyJournalList
import com.example.noswimmingserver.domain.reading_journal.service.CreateReadingJournalService
import com.example.noswimmingserver.domain.reading_journal.service.DeleteReadingJournalService
import com.example.noswimmingserver.domain.reading_journal.service.QueryMyJournalListService
import com.example.noswimmingserver.domain.reading_journal.service.QueryReadingJournalDetailService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RequestMapping("/journal")
@RestController
class ReadingJournalController(
    private val createReadingJournalService: CreateReadingJournalService,
    private val deleteReadingJournalService: DeleteReadingJournalService,
    private val queryMyJournalListService: QueryMyJournalListService,
    private val queryReadingJournalDetailService: QueryReadingJournalDetailService,
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

    @GetMapping("/list")
    fun queryMyJournalList(): QueryMyJournalList {
        return queryMyJournalListService.execute()
    }

    @GetMapping("/{reading-journal-id}")
    fun queryReadingJournalDetail(
        @PathVariable("reading-journal-id")
        readingJournalId: Long
    ): QueryJournalDetailResponse {
        return queryReadingJournalDetailService.execute(readingJournalId)
    }

}

package com.example.noswimmingserver.domain.reading_journal.service

import com.example.noswimmingserver.domain.book.facade.BookFacade
import com.example.noswimmingserver.domain.reading_journal.facade.ReadingJournalFacade
import com.example.noswimmingserver.domain.reading_journal.presentation.dto.response.QueryJournalDetailResponse
import com.example.noswimmingserver.domain.teacher.facade.TeacherFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryReadingJournalDetailService(
    private val readingJournalFacade: ReadingJournalFacade,
    private val bookFacade: BookFacade,
    private val teacherFacade: TeacherFacade,
) {

    @Transactional(readOnly = true)
    fun execute(readingJournalId: Long): QueryJournalDetailResponse {

        val readingJournal = readingJournalFacade.getReadingJournalById(readingJournalId)

        val book = bookFacade.getBookById(readingJournal.book.id)

        val teacher = teacherFacade.getTeacherById(readingJournal.teacher.userId)

        return QueryJournalDetailResponse(
            bookId = book.id,
            bookNum = book.num,
            title = readingJournal.title,
            content = readingJournal.content,
            recordReject = readingJournal.recordReject,
            isRejected = readingJournal.isRejected,
            teacherName = teacher.queryTeacherName(),
            teacherSubject = teacher.subject,
        )
    }
}

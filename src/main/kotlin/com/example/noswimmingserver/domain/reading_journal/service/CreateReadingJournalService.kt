package com.example.noswimmingserver.domain.reading_journal.service

import com.example.noswimmingserver.domain.book.facade.BookFacade
import com.example.noswimmingserver.domain.reading_journal.domain.ReadingJournal
import com.example.noswimmingserver.domain.reading_journal.domain.ReadingJournalType
import com.example.noswimmingserver.domain.reading_journal.domain.repository.ReadingJournalRepository
import com.example.noswimmingserver.domain.reading_journal.presentation.dto.request.CreateReadingJournalRequest
import com.example.noswimmingserver.domain.student.facade.StudentFacade
import com.example.noswimmingserver.domain.teacher.facade.TeacherFacade
import com.example.noswimmingserver.global.security.SecurityFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class CreateReadingJournalService(
    private val securityFacade: SecurityFacade,
    private val teacherFacade: TeacherFacade,
    private val bookFacade: BookFacade,
    private val studentFacade: StudentFacade,
    private val readingJournalRepository: ReadingJournalRepository,
) {

    @Transactional
    fun execute(bookId: Long, request: CreateReadingJournalRequest) {
        val currentUser = securityFacade.getCurrentUser()

        val student = studentFacade.getStudentById(currentUser.id)

        val teacher = teacherFacade.getTeacherById(request.teacherId)

        val book = bookFacade.getBookById(bookId)

        readingJournalRepository.save(
            ReadingJournal(
                createdAt = LocalDateTime.now(),
                book = book,
                student = student,
                teacher = teacher,
                title = request.title,
                content = request.content,
                recordReject = false,
                readingJournalType = ReadingJournalType.SAVE,
            )
        )
    }
}
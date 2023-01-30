package com.example.noswimmingserver.domain.reading_journal.service

import com.example.noswimmingserver.domain.reading_journal.exception.CannotSubmitReadingJournalException
import com.example.noswimmingserver.domain.reading_journal.facade.ReadingJournalFacade
import com.example.noswimmingserver.domain.student.facade.StudentFacade
import com.example.noswimmingserver.global.security.SecurityFacade
import com.example.noswimmingserver.infra.fcm.FcmAdapter
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SubmitReadingJournalService(
    private val fcmAdapter: FcmAdapter,
    private val readingJournalFacade: ReadingJournalFacade,
    private val securityFacade: SecurityFacade,
    private val studentFacade: StudentFacade,
) {

    @Transactional
    fun execute(readingJournalId: Long) {
        val readingJournal = readingJournalFacade.getReadingJournalById(readingJournalId)

        val user = securityFacade.getCurrentUser()

        val student = studentFacade.getStudentById(user.id)

        val teacher = readingJournal.teacher

        if (readingJournal.student.userId != user.id) {
            throw CannotSubmitReadingJournalException
        }

        readingJournal.submitJournal()

        fcmAdapter.sendMessage(
            student = student,
            teacher = teacher,
            readingJournal = readingJournal,
        )
    }
}

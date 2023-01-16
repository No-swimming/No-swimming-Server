package com.example.noswimmingserver.infra.fcm

import com.example.noswimmingserver.domain.reading_journal.domain.ReadingJournal
import com.example.noswimmingserver.domain.student.domain.Student
import com.example.noswimmingserver.domain.teacher.domain.Teacher
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import com.google.firebase.messaging.Notification
import org.springframework.stereotype.Component

@Component
class FcmAdapter {

    fun sendMessage(student: Student, teacher: Teacher, readingJournal: ReadingJournal) {
        val message = Message.builder()
            .setToken(teacher.deviceToken)
            .setTopic(readingJournal.title)
            .setNotification(
                Notification.builder()
                    .setTitle(student.queryStudentName() + "학생이" + teacher.queryTeacherName() + "선생님께 독서록을 올렸습니다.")
                    .setBody(teacher.queryTeacherName() + "선생님은 독서록을 확인해주세요!")
                    .build()
            )
            .build()

        FirebaseMessaging.getInstance().sendAsync(message)
    }
}
package com.example.noswimmingserver.domain.reading_journal.domain

import com.example.noswimmingserver.domain.book.domain.Book
import com.example.noswimmingserver.domain.feedback.domain.Feedback
import com.example.noswimmingserver.domain.student.domain.Student
import com.example.noswimmingserver.domain.teacher.domain.Teacher
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_reading_journal")
class ReadingJournal(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @field:NotNull
    val createdAt: LocalDateTime,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    val book: Book,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    val student: Student,

    @OneToMany(mappedBy = "readingJournal", cascade = [CascadeType.REMOVE])
    val feedbackList: MutableList<Feedback> = ArrayList(),

    title: String,

    content: String,

    recordReject: Boolean,

    readingJournalType: ReadingJournalType,

    teacher: Teacher,
) {
    @field:NotNull
    @Column(columnDefinition = "VARCHAR(50)")
    var title = title
        protected set

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(5000)")
    var content = content
        protected set

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", nullable = false)
    var teacher = teacher
        protected set

    @field:NotNull
    var recordReject = recordReject
        protected set

    @field:NotNull
    var readingJournalType = readingJournalType
        protected set

    fun submitJournal() {
        this.readingJournalType = ReadingJournalType.SUBMIT
    }

    fun editReadingJournal(title: String, content: String, teacher: Teacher) {
        this.title = title
        this.content = content
        this.teacher = teacher
    }

    fun changeToEndJournal() {
        this.recordReject = true
    }
}

package com.example.noswimmingserver.domain.feedback.domain

import com.example.noswimmingserver.domain.reading_journal.domain.ReadingJournal
import com.example.noswimmingserver.domain.teacher.domain.Teacher
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_feedback")
class Feedback(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @field:NotNull
    val createdAt: LocalDateTime,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reading_journal_id", nullable = false)
    val readingJournal: ReadingJournal,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", nullable = false)
    val teacher: Teacher,

    content: String,
) {

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(500)")
    var content = content
        protected set

    fun editContent(content: String) {
        this.content = content
    }
}

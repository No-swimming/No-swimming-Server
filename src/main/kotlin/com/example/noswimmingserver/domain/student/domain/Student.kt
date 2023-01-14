package com.example.noswimmingserver.domain.student.domain

import com.example.noswimmingserver.domain.common_user.domain.User
import javax.persistence.*
import javax.validation.constraints.Max
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_student")
class Student(
    @Id
    val userId: Long,

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    grade: Int,

    classNum: Int,

    number: Int,

    journalCount: Int
) {

    @field:NotNull
    @field:Max(3)
    var grade = grade
        protected set

    @field:NotNull
    @field:Max(4)
    var classNum = classNum
        protected set

    @field:NotNull
    @field:Max(20)
    var number = number
        protected set

    @field:NotNull
    var journalCount = journalCount
        protected set

    fun editStudentGCN(grade: Int, classNum: Int, number: Int) {
        this.grade = grade
        this.classNum = classNum
        this.number = number
    }
}
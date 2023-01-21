package com.example.noswimmingserver.domain.rank.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.Max
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_user_rank")
class UserRank(
    @Id
    val userId: Long,

    name: String?,

    journalCount: Int,

    grade: Int,
) {
    @Column(columnDefinition = "VARCHAR(5)")
    var name = name
        protected set

    @field:NotNull
    var journalCount = journalCount
        protected set

    @field:NotNull
    @field:Max(3)
    var grade = grade
        protected set

    fun editStudentInfo(name: String, grade: Int) {
        this.name = name
        this.grade = grade
    }
}

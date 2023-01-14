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

    @field:NotNull
    @field:Max(3)
    val grade: Int,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(5)")
    val name: String,
)
package com.example.noswimmingserver.domain.book.domain

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_book")
class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @field:NotNull
    val num: Int,

    isRead: Boolean,
) {
    @field:NotNull
    var isRead = isRead
        protected set
}

package com.example.noswimmingserver.domain.book.domain

import com.example.noswimmingserver.domain.common_user.domain.User
import javax.persistence.*

@Entity
@Table(name = "tbl_book_like")
class BookLike(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    val book: Book,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,
)
package com.example.noswimmingserver.domain.book.domain.repository

import com.example.noswimmingserver.domain.book.domain.Book
import com.example.noswimmingserver.domain.book.domain.QBook.book
import com.example.noswimmingserver.domain.book.domain.QBookLike.bookLike
import com.example.noswimmingserver.domain.book.domain.QMyBook.myBook
import com.example.noswimmingserver.domain.common_user.domain.User
import com.querydsl.jpa.impl.JPAQueryFactory

class CustomBookRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory,
) : CustomBookRepository {

    override fun queryMyLikedBookList(user: User): List<Book> =
        jpaQueryFactory
            .selectFrom(book)
            .innerJoin(bookLike)
            .on(bookLike.user.eq(user))
            .fetch()

    override fun queryMyReadBookList(user: User): List<Book> =
        jpaQueryFactory
            .selectFrom(book)
            .innerJoin(myBook)
            .on(myBook.user.eq(user))
            .fetch()
}

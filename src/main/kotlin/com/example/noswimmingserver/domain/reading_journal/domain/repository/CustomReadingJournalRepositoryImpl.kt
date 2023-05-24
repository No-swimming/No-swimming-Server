package com.example.noswimmingserver.domain.reading_journal.domain.repository

import com.example.noswimmingserver.domain.book.domain.QBook.book
import com.example.noswimmingserver.domain.reading_journal.domain.QReadingJournal.readingJournal
import com.example.noswimmingserver.domain.reading_journal.domain.repository.vo.QQueryJournalVO
import com.example.noswimmingserver.domain.reading_journal.domain.repository.vo.QueryJournalVO
import com.example.noswimmingserver.domain.student.domain.QStudent.student
import com.querydsl.jpa.impl.JPAQueryFactory

class CustomReadingJournalRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory
) : CustomReadingJournalRepository {

    override fun queryReadingJournalListByUserId(userId: Long): List<QueryJournalVO> {
        return jpaQueryFactory
            .select(
                QQueryJournalVO(
                    book.id,
                    book.num,
                    readingJournal.title,
                    readingJournal.recordReject,
                    readingJournal.readingJournalType,
                    readingJournal.id,
                    readingJournal.student.userId,
                    readingJournal.createdAt,
                )
            )
            .from(readingJournal)
            .innerJoin(readingJournal.book, book)
            .on(readingJournal.book.id.eq(book.id))
            .where(readingJournal.student.userId.eq(userId))
            .orderBy(readingJournal.createdAt.desc())
            .fetch()
    }

    override fun countMyReadingJournal(userId: Long): Long {
        return jpaQueryFactory
            .select(readingJournal.count())
            .from(readingJournal)
            .innerJoin(student)
            .on(readingJournal.student.userId.eq(userId))
            .fetchFirst()
    }
}

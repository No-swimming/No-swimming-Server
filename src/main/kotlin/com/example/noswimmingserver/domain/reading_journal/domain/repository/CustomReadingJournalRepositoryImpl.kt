package com.example.noswimmingserver.domain.reading_journal.domain.repository

import com.example.noswimmingserver.domain.book.domain.QBook.book
import com.example.noswimmingserver.domain.reading_journal.domain.QReadingJournal.readingJournal
import com.example.noswimmingserver.domain.reading_journal.domain.repository.vo.QQueryJournalVO
import com.example.noswimmingserver.domain.reading_journal.domain.repository.vo.QueryJournalVO
import com.querydsl.jpa.impl.JPAQueryFactory

class CustomReadingJournalRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory
) : CustomReadingJournalRepository {

    override fun queryMyReadingJournalList(userId: Long): List<QueryJournalVO> {
        return jpaQueryFactory
            .select(
                QQueryJournalVO(
                    book.id,
                    book.num,
                    readingJournal.recordReject,
                    readingJournal.isRejected
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
            .where(readingJournal.student.userId.eq(userId))
            .fetchFirst()
    }
}

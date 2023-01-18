package com.example.noswimmingserver.domain.rank.domain.repository

import com.example.noswimmingserver.domain.rank.domain.QUserRank.userRank
import com.example.noswimmingserver.domain.rank.domain.UserRank
import com.querydsl.jpa.impl.JPAQueryFactory

class CustomUserRankingRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory
) : CustomUserRankingRepository {

    override fun queryUserRanking(): List<UserRank> {
        return jpaQueryFactory
            .selectFrom(userRank)
            //.where(readingJournal.createdAt.gt(LocalDateTime.of(2023, 1, 1, 0, 0, 0)))
            .orderBy(userRank.journalCount.desc())
            .fetch()
    }

}


package com.example.noswimmingserver.domain.rank.domain.repository

import com.example.noswimmingserver.domain.common_user.domain.QUser.user
import com.example.noswimmingserver.domain.rank.domain.QUserRank.userRank
import com.example.noswimmingserver.domain.rank.domain.UserRank
import com.querydsl.jpa.impl.JPAQueryFactory

class CustomUserRankingRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory
) : CustomUserRankingRepository {

    override fun queryUserRanking(): List<UserRank> {
        return jpaQueryFactory
            .selectFrom(userRank)
            .orderBy(userRank.journalCount.desc())
            .fetch()
    }

    override fun countAllUsers(): Long = // 전체 유저 수 구하기
        jpaQueryFactory
            .select(userRank.count())
            .from(userRank)
            .fetchFirst()

    override fun countLessThanMe(userId: Long): Long = // 내 독서록 수보다 적게 작성한 사람 수 구하기
        jpaQueryFactory
            .select(userRank.count())
            .from(userRank)
            .innerJoin(user)
            .on(userRank.journalCount.lt(countMyJournal(userId)))
            .fetchFirst()

    private fun countMyJournal(userId: Long): Long = // 내 독서록 수 구하기
        jpaQueryFactory
            .select(userRank.count())
            .from(userRank)
            .where(userRank.userId.eq(userId))
            .fetchFirst()
}

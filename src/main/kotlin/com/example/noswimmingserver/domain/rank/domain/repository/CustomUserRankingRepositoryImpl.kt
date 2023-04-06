package com.example.noswimmingserver.domain.rank.domain.repository

import com.example.noswimmingserver.domain.common_user.domain.QUser.user
import com.example.noswimmingserver.domain.rank.domain.QUserRank.userRank
import com.example.noswimmingserver.domain.rank.domain.UserRank
import com.querydsl.jpa.impl.JPAQueryFactory

class CustomUserRankingRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory
) : CustomUserRankingRepository {

    override fun queryUserRanking(): List<UserRank> =
        jpaQueryFactory
            .selectFrom(userRank)
            .orderBy(userRank.journalCount.desc())
            .fetch()

    override fun countAllUsers(): Int = // 전체 유저 수 구하기
        jpaQueryFactory
            .select(userRank.userId)
            .from(userRank)
            .fetch().size

    override fun countLessThanMe(userId: Long): Int = // 내 독서록 수보다 적게 작성한 사람 수 구하기
        jpaQueryFactory
            .select(userRank.userId)
            .from(userRank)
            .innerJoin(user)
            .on(userRank.journalCount.lt(countMyJournal(userId)))
            .fetch().size

    private fun countMyJournal(userId: Long): Int = // 내 독서록 수 구하기
        jpaQueryFactory
            .select(userRank.userId)
            .from(userRank)
            .where(userRank.userId.eq(userId))
            .fetch().size
}

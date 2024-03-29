package com.example.noswimmingserver.domain.rank.domain.repository

import com.example.noswimmingserver.domain.rank.domain.UserRank

interface CustomUserRankingRepository {

    fun queryUserRanking(): List<UserRank>

    fun countAllUsers(): Int

    fun countLessThanMe(userId: Long): Int
}

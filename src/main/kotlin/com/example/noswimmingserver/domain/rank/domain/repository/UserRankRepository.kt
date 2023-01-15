package com.example.noswimmingserver.domain.rank.domain.repository

import com.example.noswimmingserver.domain.rank.domain.UserRank
import org.springframework.data.jpa.repository.JpaRepository

interface UserRankRepository : JpaRepository<UserRank, Long>, CustomUserRankingRepository {
}
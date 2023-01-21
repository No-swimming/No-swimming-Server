package com.example.noswimmingserver.domain.rank.facade

import com.example.noswimmingserver.domain.rank.domain.UserRank
import com.example.noswimmingserver.domain.rank.domain.repository.UserRankRepository
import com.example.noswimmingserver.domain.rank.exception.UserRankNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class RankFacade(
    private val userRankRepository: UserRankRepository,
) {

    fun getRankById(userId: Long): UserRank {
        return userRankRepository.findByIdOrNull(userId)
            ?: throw UserRankNotFoundException
    }
}

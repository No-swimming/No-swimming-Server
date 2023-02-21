package com.example.noswimmingserver.domain.rank.service

import com.example.noswimmingserver.domain.rank.domain.repository.UserRankRepository
import com.example.noswimmingserver.domain.rank.presentation.dto.response.QueryUserRankingElement
import com.example.noswimmingserver.domain.rank.presentation.dto.response.QueryUserRankingList
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserRankingService(
    private val userRankRepository: UserRankRepository,
) {

    @Transactional(readOnly = true)
    fun queryUserRanking(): QueryUserRankingList {
        val userRankingList = userRankRepository.queryUserRanking()

        return QueryUserRankingList(
            userRankingList = userRankingList

                .map {
                    QueryUserRankingElement(
                        name = it.name!!,
                        grade = it.grade,
                        journalCount = it.journalCount,
                    )
                }
        )
    }
}
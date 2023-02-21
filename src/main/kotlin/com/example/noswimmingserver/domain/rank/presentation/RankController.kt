package com.example.noswimmingserver.domain.rank.presentation

import com.example.noswimmingserver.domain.rank.presentation.dto.response.QueryUserRankingList
import com.example.noswimmingserver.domain.rank.service.UserRankingService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/rank")
@RestController
class RankController(
    private val userRankingService: UserRankingService,
) {

    @GetMapping
    fun queryUserRanking(): QueryUserRankingList {
        return userRankingService.queryUserRanking()
    }
}
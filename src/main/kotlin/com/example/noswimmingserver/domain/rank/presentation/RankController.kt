package com.example.noswimmingserver.domain.rank.presentation

import com.example.noswimmingserver.domain.rank.presentation.dto.response.QueryUserRankingList
import com.example.noswimmingserver.domain.rank.service.QueryUserRankingService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/rank")
@RestController
class RankController(
    private val queryUserRankingService: QueryUserRankingService,
) {

    @GetMapping
    fun queryUserRanking(): QueryUserRankingList {
        return queryUserRankingService.execute()
    }
}
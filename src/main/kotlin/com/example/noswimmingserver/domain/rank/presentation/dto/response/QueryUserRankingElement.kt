package com.example.noswimmingserver.domain.rank.presentation.dto.response

data class QueryUserRankingElement(
    val grade: Int,
    val name: String,
    val journalCount: Int,
)

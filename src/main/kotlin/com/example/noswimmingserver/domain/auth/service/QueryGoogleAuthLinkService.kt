package com.example.noswimmingserver.domain.auth.service

import com.example.noswimmingserver.domain.common_user.presentation.dto.response.LinkResponse
import com.example.noswimmingserver.infra.feign.properties.GoogleFeignProperties
import org.springframework.stereotype.Service

@Service
class QueryGoogleAuthLinkService(
    private val googleFeignProperties: GoogleFeignProperties,
) {

    companion object {
        const val GOOGLE_LINK = "%s?client_id=%s&redirect_uri=%s&response_type=code" +
                "&scope=https://www.googleapis.com/auth/userinfo.email"
    }

    fun execute(): LinkResponse = LinkResponse(queryLink())

    private fun queryLink(): String {
        return String.format(
            GOOGLE_LINK,
            googleFeignProperties.baseUrl,
            googleFeignProperties.clientId,
            googleFeignProperties.redirectUri
        )
    }
}
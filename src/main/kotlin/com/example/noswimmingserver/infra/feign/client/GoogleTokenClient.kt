package com.example.noswimmingserver.infra.feign.client

import com.example.noswimmingserver.infra.feign.dto.request.GoogleCodeRequest
import com.example.noswimmingserver.infra.feign.dto.response.TokenResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping

@FeignClient(name = "GoogleAuthClient", url = "https://oauth2.googleapis.com/token")
interface GoogleTokenClient {

    @PostMapping
    fun googleAuth(googleCodeRequest: GoogleCodeRequest): TokenResponse

}
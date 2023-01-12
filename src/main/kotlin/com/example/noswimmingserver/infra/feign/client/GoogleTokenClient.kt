package com.example.noswimmingserver.infra.feign.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping

@FeignClient(name = "GoogleAuthClient", url = "https://oauth2.googleapis.com/token")
interface GoogleTokenClient {

    @PostMapping
    fun googleAuth(googleCodeRequest: GoogleCodeRequest): TokenResponse

}
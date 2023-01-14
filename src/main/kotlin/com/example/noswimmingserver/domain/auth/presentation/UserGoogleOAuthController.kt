package com.example.noswimmingserver.domain.auth.presentation

import com.example.noswimmingserver.domain.auth.service.GoogleAuthService
import com.example.noswimmingserver.domain.auth.service.QueryGoogleAuthLinkService
import com.example.noswimmingserver.domain.common_user.presentation.dto.response.LinkResponse
import com.example.noswimmingserver.domain.common_user.presentation.dto.response.TokenResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/auth")
@RestController
class UserGoogleOAuthController(
    private val queryGoogleAuthLinkService: QueryGoogleAuthLinkService,
    private val googleAuthService: GoogleAuthService,
) {

    @GetMapping("/link")
    fun queryGoogleAuthLink(): LinkResponse {
        return queryGoogleAuthLinkService.execute()
    }

    @GetMapping("/google")
    fun userSignUpOrIn(@RequestParam("code") code: String): ResponseEntity<TokenResponse> {
        return googleAuthService.execute(code)
    }
}
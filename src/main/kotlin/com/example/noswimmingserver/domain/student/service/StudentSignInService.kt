package com.example.noswimmingserver.domain.student.service

import com.example.noswimmingserver.domain.common_user.presentation.dto.response.TokenResponse
import com.example.noswimmingserver.domain.student.presentation.dto.request.StudentSignInRequest
import com.example.noswimmingserver.global.security.jwt.JwtProvider
import org.springframework.stereotype.Service

@Service
class StudentSignInService(
    private val jwtProvider: JwtProvider,
) {

    fun execute(request: StudentSignInRequest): TokenResponse =
        jwtProvider.getToken(request.email)
}

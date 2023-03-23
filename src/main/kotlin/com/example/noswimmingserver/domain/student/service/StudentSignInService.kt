package com.example.noswimmingserver.domain.student.service

import com.example.noswimmingserver.domain.common_user.domain.repository.UserRepository
import com.example.noswimmingserver.domain.common_user.presentation.dto.response.TokenResponse
import com.example.noswimmingserver.domain.student.exception.StudentNotFoundException
import com.example.noswimmingserver.domain.student.presentation.dto.request.StudentSignInRequest
import com.example.noswimmingserver.domain.teacher.exception.PasswordMisMatchException
import com.example.noswimmingserver.global.security.jwt.JwtProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class StudentSignInService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtProvider: JwtProvider,
) {

    fun execute(request: StudentSignInRequest): TokenResponse {
        val user = userRepository.findByEmail(request.email)
            ?: throw StudentNotFoundException

        if (!passwordEncoder.matches(request.password, user.password)) {
            throw PasswordMisMatchException
        }

        return jwtProvider.getToken(request.email)
    }
}

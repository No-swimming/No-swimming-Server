package com.example.noswimmingserver.domain.auth.service

import com.example.noswimmingserver.domain.common_user.domain.User
import com.example.noswimmingserver.domain.common_user.domain.repository.UserRepository
import com.example.noswimmingserver.domain.common_user.exception.code.InvalidEmailException
import com.example.noswimmingserver.domain.common_user.presentation.dto.response.TokenResponse
import com.example.noswimmingserver.domain.student.domain.Student
import com.example.noswimmingserver.domain.student.domain.repository.StudentRepository
import com.example.noswimmingserver.global.enum.Authority
import com.example.noswimmingserver.global.security.jwt.JwtProvider
import com.example.noswimmingserver.global.util.RegexUtil
import com.example.noswimmingserver.infra.feign.client.GoogleInfoClient
import com.example.noswimmingserver.infra.feign.client.GoogleTokenClient
import com.example.noswimmingserver.infra.feign.dto.request.GoogleCodeRequest
import com.example.noswimmingserver.infra.feign.properties.GoogleFeignProperties
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

@Service
class GoogleAuthService(
    private val userRepository: UserRepository,
    private val studentRepository: StudentRepository,
    private val googleInfoClient: GoogleInfoClient,
    private val googleTokenClient: GoogleTokenClient,
    private val googleFeignProperties: GoogleFeignProperties,
    private val jwtTokenProvider: JwtProvider
) {

    fun execute(code: String): ResponseEntity<TokenResponse> {
        val accessToken = googleTokenClient.googleAuth(
            GoogleCodeRequest(
                code = URLDecoder.decode(code, StandardCharsets.UTF_8),
                clientId = googleFeignProperties.clientId,
                clientSecret = googleFeignProperties.clientSecret,
                redirectUri = googleFeignProperties.redirectUri
            )
        ).accessToken

        val googleInfoResponse = googleInfoClient.getUserInfo(accessToken)

        val email = googleInfoResponse.email

        var user = userRepository.findByEmail(email)

        if (!email.endsWith(RegexUtil.SCHOOL_EMAIL)) {
            throw InvalidEmailException
        }

        var status = HttpStatus.OK

        if (user == null) {
            user = User(
                email = email,
                password = null,
                authority = Authority.STUDENT,
                name = null
            )
            userRepository.save(user)

            studentRepository.save(
                Student(
                    userId = user.id,
                    user = user,
                    grade = 0,
                    classNum = 0,
                    number = 0,
                    journalCount = 0
                )
            )
            status = HttpStatus.CREATED
        }

        return ResponseEntity<TokenResponse>(
            jwtTokenProvider.getToken(email),
            status
        )
    }
}
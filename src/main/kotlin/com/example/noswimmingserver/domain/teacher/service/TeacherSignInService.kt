package com.example.noswimmingserver.domain.teacher.service

import com.example.noswimmingserver.domain.common_user.domain.repository.UserRepository
import com.example.noswimmingserver.domain.common_user.presentation.dto.response.TokenResponse
import com.example.noswimmingserver.domain.teacher.exception.PasswordMisMatchException
import com.example.noswimmingserver.domain.teacher.exception.TeacherNotFoundException
import com.example.noswimmingserver.domain.teacher.facade.TeacherFacade
import com.example.noswimmingserver.domain.teacher.presentation.dto.request.TeacherSignInRequest
import com.example.noswimmingserver.global.security.jwt.JwtProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TeacherSignInService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtProvider: JwtProvider,
    private val teacherFacade: TeacherFacade,
) {

    @Transactional
    fun execute(request: TeacherSignInRequest): TokenResponse {
        val teacher = userRepository.findByEmail(request.email)
            ?: throw TeacherNotFoundException

        if (!passwordEncoder.matches(request.password, teacher.password)) {
            throw PasswordMisMatchException
        }

        teacherFacade.saveDeviceToken(
            deviceToken = request.deviceToken,
            teacherId = teacher.id,
        )

        return jwtProvider.getToken(request.email)
    }
}

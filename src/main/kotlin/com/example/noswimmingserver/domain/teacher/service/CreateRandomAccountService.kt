package com.example.noswimmingserver.domain.teacher.service

import com.example.noswimmingserver.domain.common_user.domain.User
import com.example.noswimmingserver.domain.common_user.domain.repository.UserRepository
import com.example.noswimmingserver.domain.teacher.domain.Teacher
import com.example.noswimmingserver.domain.teacher.domain.repository.TeacherRepository
import com.example.noswimmingserver.domain.teacher.presentation.dto.response.TeacherAccountResponse
import com.example.noswimmingserver.global.enum.Authority
import com.example.noswimmingserver.global.util.RandomAccountUtil
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateRandomAccountService(
    private val userRepository: UserRepository,
    private val teacherRepository: TeacherRepository,
    private val passwordEncoder: PasswordEncoder,
    private val randomAccountUtil: RandomAccountUtil,
) {

    @Transactional
    fun execute(): TeacherAccountResponse {
        val email = randomAccountUtil.createRandomEmail()
        val password = randomAccountUtil.createRandomPassword()

        val user = User(
            email = email,
            password = passwordEncoder.encode(password),
            authority = Authority.TEACHER,
            name = null,
        )

        userRepository.save(user)

        teacherRepository.save(
            Teacher(
                userId = user.id,
                user = user,
                subject = null,
                deviceToken = null
            )
        )

        return TeacherAccountResponse(email, password)
    }

}
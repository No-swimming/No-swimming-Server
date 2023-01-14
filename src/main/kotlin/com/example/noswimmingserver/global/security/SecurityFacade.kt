package com.example.noswimmingserver.global.security

import com.example.noswimmingserver.domain.common_user.domain.User
import com.example.noswimmingserver.domain.common_user.domain.repository.UserRepository
import com.example.noswimmingserver.domain.common_user.exception.UserNotFoundException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class SecurityFacade(
    private val userRepository: UserRepository,
) {

    fun getCurrentUser(): User {
        val email = SecurityContextHolder.getContext().authentication.name
        return userRepository.findByEmail(email)
            ?: throw UserNotFoundException
    }
}
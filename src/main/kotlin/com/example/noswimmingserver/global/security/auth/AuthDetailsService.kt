package com.example.noswimmingserver.global.security.auth

import com.example.noswimmingserver.domain.common_user.domain.repository.UserRepository
import com.example.noswimmingserver.domain.common_user.exception.UserNotFoundException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {

    override fun loadUserByUsername(email: String): UserDetails {
        val user = userRepository.findByEmail(email)
            ?: throw UserNotFoundException

        return AuthDetails(user)
    }
}
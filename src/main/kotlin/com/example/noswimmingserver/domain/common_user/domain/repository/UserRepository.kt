package com.example.noswimmingserver.domain.common_user.domain.repository

import com.example.noswimmingserver.domain.common_user.domain.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {

    fun findByEmail(email: String): User?
}
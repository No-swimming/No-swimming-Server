package com.example.noswimmingserver.domain.common_user.domain.repository

import com.querydsl.jpa.impl.JPAQueryFactory

class CustomUserRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory,
) : CustomUserRepository {

//    override fun queryMyInfo(userId: Long): List<User> {
//        return jpaQueryFactory
//            .selectFrom(user)
//            .innerJoin(student)
//            .on(student.userId.eq(userId))
//            .fetch()
//    }
}
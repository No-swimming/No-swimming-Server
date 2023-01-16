package com.example.noswimmingserver.domain.teacher.domain.repository

import com.example.noswimmingserver.domain.teacher.domain.QTeacher.teacher
import com.example.noswimmingserver.domain.teacher.domain.Teacher
import com.querydsl.jpa.impl.JPAQueryFactory

class CustomTeacherRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory
) : CustomTeacherRepository {

    override fun queryTeacherListOrderByTeacherId(): List<Teacher> {
        return jpaQueryFactory
            .selectFrom(teacher)
            .orderBy(teacher.userId.asc())
            .fetch()
    }
}
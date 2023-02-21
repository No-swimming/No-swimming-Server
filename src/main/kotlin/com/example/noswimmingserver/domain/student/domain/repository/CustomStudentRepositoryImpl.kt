package com.example.noswimmingserver.domain.student.domain.repository

import com.example.noswimmingserver.domain.student.domain.QStudent.student
import com.example.noswimmingserver.domain.student.domain.Student
import com.querydsl.jpa.impl.JPAQueryFactory

class CustomStudentRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory,
) : CustomStudentRepository {

    override fun queryStudentList(): List<Student> =
        jpaQueryFactory
            .selectFrom(student)
            .fetch()
}

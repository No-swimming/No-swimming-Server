package com.example.noswimmingserver.domain.student.domain.repository

import com.example.noswimmingserver.domain.student.domain.QStudent.student
import com.example.noswimmingserver.domain.student.domain.Student
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory

class CustomStudentRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory,
) : CustomStudentRepository {

    override fun queryStudentListByGradeAndClassNum(grade: Int, classNum: Int): List<Student> {
        return jpaQueryFactory
            .selectFrom(student)
            .where(
                gradeEq(grade),
                classNumEq(classNum),
            )
            .fetch()
    }

    private fun gradeEq(grade: Int): BooleanExpression = student.grade.eq(grade)

    private fun classNumEq(classNum: Int): BooleanExpression = student.classNum.eq(classNum)
}

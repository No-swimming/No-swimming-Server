package com.example.noswimmingserver.domain.student.domain.repository

import com.example.noswimmingserver.domain.student.domain.Student

interface CustomStudentRepository {

    fun queryStudentListByGradeAndClassNum(grade: Int, classNum: Int): List<Student>
}

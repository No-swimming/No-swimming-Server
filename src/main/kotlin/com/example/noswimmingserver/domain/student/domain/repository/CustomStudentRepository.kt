package com.example.noswimmingserver.domain.student.domain.repository

import com.example.noswimmingserver.domain.student.domain.Student

interface CustomStudentRepository {

    fun queryStudentList(): List<Student>
}

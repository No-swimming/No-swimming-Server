package com.example.noswimmingserver.domain.teacher.domain.repository

import com.example.noswimmingserver.domain.teacher.domain.Teacher

interface CustomTeacherRepository {

    fun queryTeacherListOrderByTeacherId(): List<Teacher>
}
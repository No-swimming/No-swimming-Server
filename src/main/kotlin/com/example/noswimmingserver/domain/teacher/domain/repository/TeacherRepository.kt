package com.example.noswimmingserver.domain.teacher.domain.repository

import com.example.noswimmingserver.domain.teacher.domain.Teacher
import org.springframework.data.repository.CrudRepository

interface TeacherRepository : CrudRepository<Teacher, Long> {
}
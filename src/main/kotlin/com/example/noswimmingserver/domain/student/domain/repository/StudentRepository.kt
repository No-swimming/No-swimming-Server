package com.example.noswimmingserver.domain.student.domain.repository

import com.example.noswimmingserver.domain.student.domain.Student
import org.springframework.data.repository.CrudRepository

interface StudentRepository : CrudRepository<Student, Long> {
}
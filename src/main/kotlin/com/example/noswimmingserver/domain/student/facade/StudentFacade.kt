package com.example.noswimmingserver.domain.student.facade

import com.example.noswimmingserver.domain.student.domain.Student
import com.example.noswimmingserver.domain.student.domain.repository.StudentRepository
import com.example.noswimmingserver.domain.student.exception.StudentNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class StudentFacade(
    private val studentRepository: StudentRepository,
) {

    fun getStudentById(studentId: Long): Student {
        return studentRepository.findByIdOrNull(studentId)
            ?: throw StudentNotFoundException
    }
}
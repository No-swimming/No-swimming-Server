package com.example.noswimmingserver.domain.student.service

import com.example.noswimmingserver.domain.common_user.domain.repository.UserRepository
import com.example.noswimmingserver.domain.student.domain.repository.StudentRepository
import com.example.noswimmingserver.domain.student.facade.StudentFacade
import com.example.noswimmingserver.global.security.SecurityFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class StudentWithdrawalService(
    private val securityFacade: SecurityFacade,
    private val studentFacade: StudentFacade,
    private val userRepository: UserRepository,
    private val studentRepository: StudentRepository,
) {

    @Transactional
    fun execute() {
        val user = securityFacade.getCurrentUser()
        val student = studentFacade.getStudentById(user.id)
        studentRepository.delete(student)
        userRepository.delete(user)
    }
}

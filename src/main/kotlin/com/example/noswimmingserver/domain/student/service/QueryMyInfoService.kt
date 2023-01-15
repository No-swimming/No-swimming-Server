package com.example.noswimmingserver.domain.student.service

import com.example.noswimmingserver.domain.student.facade.StudentFacade
import com.example.noswimmingserver.domain.student.presentation.dto.response.QueryMyInfoResponse
import com.example.noswimmingserver.global.security.SecurityFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryMyInfoService(
    private val securityFacade: SecurityFacade,
    private val studentFacade: StudentFacade,
) {

    @Transactional(readOnly = true)
    fun execute(): QueryMyInfoResponse {
        val user = securityFacade.getCurrentUser()

        val student = studentFacade.getStudentById(user.id)

        return QueryMyInfoResponse(
            email = user.email,
            name = user.name!!,
            grade = student.grade,
            classNum = student.classNum,
            number = student.number,
        )
    }
}
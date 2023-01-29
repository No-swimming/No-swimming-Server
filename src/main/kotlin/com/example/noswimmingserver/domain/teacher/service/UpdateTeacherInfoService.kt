package com.example.noswimmingserver.domain.teacher.service

import com.example.noswimmingserver.domain.teacher.facade.TeacherFacade
import com.example.noswimmingserver.domain.teacher.presentation.dto.request.UpdateTeacherInfoRequest
import com.example.noswimmingserver.global.security.SecurityFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UpdateTeacherInfoService(
    private val securityFacade: SecurityFacade,
    private val teacherFacade: TeacherFacade,
) {

    @Transactional
    fun execute(request: UpdateTeacherInfoRequest) {
        val user = securityFacade.getCurrentUser()

        val teacher = teacherFacade.getTeacherById(user.id)

        user.editName(name = request.name)

        teacher.editSubject(subject = request.subject)
    }
}
package com.example.noswimmingserver.domain.teacher.service

import com.example.noswimmingserver.domain.teacher.facade.TeacherFacade
import com.example.noswimmingserver.global.security.SecurityFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TeacherLogOutService(
    private val securityFacade: SecurityFacade,
    private val teacherFacade: TeacherFacade,
) {

    @Transactional
    fun execute() {
        val user = securityFacade.getCurrentUser()

        val teacher = teacherFacade.getTeacherById(user.id)

        teacher.deleteDeviceToken()
    }
}

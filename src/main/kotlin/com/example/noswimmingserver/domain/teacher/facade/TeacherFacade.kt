package com.example.noswimmingserver.domain.teacher.facade

import com.example.noswimmingserver.domain.teacher.domain.Teacher
import com.example.noswimmingserver.domain.teacher.domain.repository.TeacherRepository
import com.example.noswimmingserver.domain.teacher.exception.TeacherNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class TeacherFacade(
    private val teacherRepository: TeacherRepository,
) {

    fun getTeacherById(teacherId: Long): Teacher {
        return teacherRepository.findByIdOrNull(teacherId)
            ?: throw TeacherNotFoundException
    }

    fun saveDeviceToken(deviceToken: String, teacherId: Long) {
        val teacher = getTeacherById(teacherId)
        teacher.saveDeviceToken(deviceToken)
    }
}
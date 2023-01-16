package com.example.noswimmingserver.domain.teacher.service

import com.example.noswimmingserver.domain.teacher.domain.repository.TeacherRepository
import com.example.noswimmingserver.domain.teacher.presentation.dto.response.QueryTeacherElement
import com.example.noswimmingserver.domain.teacher.presentation.dto.response.QueryTeacherList
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryTeacherListService(
    private val teacherRepository: TeacherRepository,
) {

    @Transactional(readOnly = true)
    fun execute(): QueryTeacherList {
        val teacherList = teacherRepository.queryTeacherListOrderByTeacherId()

        return QueryTeacherList(
            teacherList
                .map {
                    QueryTeacherElement(
                        teacherId = it.userId,
                        teacherName = it.queryTeacherName(),
                        subject = it.subject!!,
                    )
                }
        )
    }
}
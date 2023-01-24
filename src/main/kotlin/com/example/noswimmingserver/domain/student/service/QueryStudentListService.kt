package com.example.noswimmingserver.domain.student.service

import com.example.noswimmingserver.domain.student.domain.repository.StudentRepository
import com.example.noswimmingserver.domain.student.presentation.dto.response.QueryStudentElement
import com.example.noswimmingserver.domain.student.presentation.dto.response.QueryStudentList
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryStudentListService(
    private val studentRepository: StudentRepository,
) {

    @Transactional(readOnly = true)
    fun execute(grade: Int, classNum: Int): QueryStudentList {
        val studentList = studentRepository.queryStudentListByGradeAndClassNum(grade, classNum)

        return QueryStudentList(
            studentList = studentList
                .map {
                    QueryStudentElement(
                        grade = it.grade,
                        classNum = it.classNum,
                        number = it.number,
                        name = it.queryStudentName(),
                    )
                }
        )
    }
}

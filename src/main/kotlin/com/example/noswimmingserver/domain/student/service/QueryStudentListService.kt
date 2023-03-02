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
    fun execute(grade: Int?, classNum: Int?): QueryStudentList {
        val studentList = studentRepository.queryStudentList()

        val response = studentList
            .filter { student ->
                when {
                    grade != null && classNum == null -> student.grade == grade
                    grade == null && classNum != null -> student.classNum == classNum
                    grade != null && classNum != null -> student.grade == grade && student.classNum == classNum
                    else -> return@filter true
                }
            }
            .map { student ->
                QueryStudentElement(
                    grade = student.grade,
                    classNum = student.classNum,
                    number = student.number,
                    name = student.queryStudentName(),
                )
            }

        return QueryStudentList(response)
    }
}

package com.example.noswimmingserver.domain.student.presentation

import com.example.noswimmingserver.domain.student.presentation.dto.request.UpdateStudentInfoRequest
import com.example.noswimmingserver.domain.student.presentation.dto.response.QueryMyInfoResponse
import com.example.noswimmingserver.domain.student.presentation.dto.response.QueryStudentList
import com.example.noswimmingserver.domain.student.service.QueryMyInfoService
import com.example.noswimmingserver.domain.student.service.QueryStudentListService
import com.example.noswimmingserver.domain.student.service.StudentWithdrawalService
import com.example.noswimmingserver.domain.student.service.UpdateStudentInfoService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RequestMapping("/student")
@RestController
class StudentController(
    private val updateStudentInfoService: UpdateStudentInfoService,
    private val studentWithdrawalService: StudentWithdrawalService,
    private val queryMyInfoService: QueryMyInfoService,
    private val queryStudentListService: QueryStudentListService,
) {

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping
    fun editStudentInfo(@RequestBody @Valid request: UpdateStudentInfoRequest) {
        updateStudentInfoService.execute(request)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    fun withdrawalStudent() {
        studentWithdrawalService.execute()
    }

    @GetMapping
    fun queryStudentInfo(): QueryMyInfoResponse {
        return queryMyInfoService.execute()
    }

    @GetMapping("/list")
    fun queryStudentListByGradeAndClassNum(
        @RequestParam grade: Int?,
        @RequestParam classNum: Int?,
    ): QueryStudentList {
        return queryStudentListService.execute(grade, classNum)
    }
}

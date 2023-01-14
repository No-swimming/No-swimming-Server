package com.example.noswimmingserver.domain.student.presentation

import com.example.noswimmingserver.domain.student.presentation.dto.request.UpdateStudentInfoRequest
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
}
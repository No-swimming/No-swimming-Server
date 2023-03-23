package com.example.noswimmingserver.domain.student.presentation

import com.example.noswimmingserver.domain.common_user.presentation.dto.response.TokenResponse
import com.example.noswimmingserver.domain.student.presentation.dto.request.StudentSignInRequest
import com.example.noswimmingserver.domain.student.presentation.dto.request.UpdateStudentInfoRequest
import com.example.noswimmingserver.domain.student.presentation.dto.response.QueryMyInfoResponse
import com.example.noswimmingserver.domain.student.presentation.dto.response.QueryStudentList
import com.example.noswimmingserver.domain.student.service.QueryMyInfoService
import com.example.noswimmingserver.domain.student.service.QueryStudentListService
import com.example.noswimmingserver.domain.student.service.StudentSignInService
import com.example.noswimmingserver.domain.student.service.StudentWithdrawalService
import com.example.noswimmingserver.domain.student.service.UpdateStudentInfoService
import com.example.noswimmingserver.domain.teacher.service.TeacherSignInService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RequestMapping("/student")
@RestController
class StudentController(
    private val studentSignInService: StudentSignInService,
    private val updateStudentInfoService: UpdateStudentInfoService,
    private val studentWithdrawalService: StudentWithdrawalService,
    private val queryMyInfoService: QueryMyInfoService,
    private val queryStudentListService: QueryStudentListService,
) {

    @PostMapping("/token")
    fun studentSignIn(@RequestBody @Valid request: StudentSignInRequest): TokenResponse {
        return studentSignInService.execute(request)
    }

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

package com.example.noswimmingserver.domain.teacher.presentation

import com.example.noswimmingserver.domain.common_user.presentation.dto.response.TokenResponse
import com.example.noswimmingserver.domain.teacher.presentation.dto.request.TeacherSignInRequest
import com.example.noswimmingserver.domain.teacher.presentation.dto.request.UpdateTeacherInfoRequest
import com.example.noswimmingserver.domain.teacher.presentation.dto.response.TeacherAccountResponse
import com.example.noswimmingserver.domain.teacher.service.CreateRandomAccountService
import com.example.noswimmingserver.domain.teacher.service.TeacherSignInService
import com.example.noswimmingserver.domain.teacher.service.UpdateTeacherInfoService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RequestMapping("/teacher")
@RestController
class TeacherController(
    private val createRandomAccountService: CreateRandomAccountService,
    private val updateTeacherInfoService: UpdateTeacherInfoService,
    private val teacherSignInService: TeacherSignInService,
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createRandomAccount(): TeacherAccountResponse {
        return createRandomAccountService.execute()
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping
    fun editTeacherInfo(@RequestBody @Valid request: UpdateTeacherInfoRequest) {
        updateTeacherInfoService.execute(request)
    }

    @PostMapping("/token")
    fun teacherSignIn(@RequestBody @Valid request: TeacherSignInRequest): TokenResponse {
        return teacherSignInService.execute(request)
    }
}
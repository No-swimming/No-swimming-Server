package com.example.noswimmingserver.domain.teacher.presentation

import com.example.noswimmingserver.domain.teacher.presentation.dto.request.UpdateTeacherInfoRequest
import com.example.noswimmingserver.domain.teacher.presentation.dto.response.TeacherAccountResponse
import com.example.noswimmingserver.domain.teacher.service.CreateRandomAccountService
import com.example.noswimmingserver.domain.teacher.service.UpdateTeacherInfoService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RequestMapping("/teacher")
@RestController
class TeacherController(
    private val createRandomAccountService: CreateRandomAccountService,
    private val updateTeacherInfoService: UpdateTeacherInfoService,
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
}
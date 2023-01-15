package com.example.noswimmingserver.domain.teacher.presentation

import com.example.noswimmingserver.domain.teacher.presentation.dto.response.AccountResponse
import com.example.noswimmingserver.domain.teacher.service.CreateRandomAccountService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/teacher")
@RestController
class TeacherController(
    private val createRandomAccountService: CreateRandomAccountService,
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createRandomAccount(): AccountResponse {
        return createRandomAccountService.execute()
    }
}
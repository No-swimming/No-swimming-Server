package com.example.noswimmingserver.domain.student.presentation

import com.example.noswimmingserver.domain.student.presentation.dto.request.UpdateStudentInfoRequest
import com.example.noswimmingserver.domain.student.service.UpdateStudentInfoService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RequestMapping("/student")
@RestController
class StudentController(
    private val updateStudentInfoService: UpdateStudentInfoService,
) {

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping
    fun editStudentInfo(@RequestBody @Valid request: UpdateStudentInfoRequest) {
        updateStudentInfoService.execute(request)
    }
}
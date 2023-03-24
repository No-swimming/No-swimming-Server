package com.example.noswimmingserver.domain.teacher.presentation

import com.example.noswimmingserver.domain.common_user.presentation.dto.response.TokenResponse
import com.example.noswimmingserver.domain.teacher.presentation.dto.request.TeacherSignInRequest
import com.example.noswimmingserver.domain.teacher.presentation.dto.request.UpdateTeacherInfoRequest
import com.example.noswimmingserver.domain.teacher.presentation.dto.response.QueryStudentJournalList
import com.example.noswimmingserver.domain.teacher.presentation.dto.response.QueryTeacherList
import com.example.noswimmingserver.domain.teacher.presentation.dto.response.TeacherAccountResponse
import com.example.noswimmingserver.domain.teacher.service.*
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RequestMapping("/teacher")
@RestController
class TeacherController(
    private val createRandomAccountService: CreateRandomAccountService,
    private val updateTeacherInfoService: UpdateTeacherInfoService,
    private val teacherSignInService: TeacherSignInService,
    private val queryTeacherListService: QueryTeacherListService,
    private val queryStudentJournalListService: QueryStudentJournalListService,
    private val teacherLogOutService: TeacherLogOutService,
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createRandomAccount(): TeacherAccountResponse {
        return createRandomAccountService.execute()
    }

    @PostMapping("/device-token")
    fun teacherSignIn(@RequestBody @Valid request: TeacherSignInRequest): TokenResponse {
        return teacherSignInService.execute(request)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping
    fun editTeacherInfo(@RequestBody @Valid request: UpdateTeacherInfoRequest) {
        updateTeacherInfoService.execute(request)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    fun logOutTeacher() {
        teacherLogOutService.execute()
    }

    @GetMapping("/list")
    fun queryTeacherList(): QueryTeacherList {
        return queryTeacherListService.execute()
    }

    @GetMapping("/student/journal")
    fun queryStudentJournalByUserId(@RequestParam userId: Long): QueryStudentJournalList {
        return queryStudentJournalListService.execute(userId)
    }
}

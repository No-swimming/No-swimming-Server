package com.example.noswimmingserver.domain.student.service

import com.example.noswimmingserver.domain.rank.facade.RankFacade
import com.example.noswimmingserver.domain.student.facade.StudentFacade
import com.example.noswimmingserver.domain.student.presentation.dto.request.UpdateStudentInfoRequest
import com.example.noswimmingserver.global.security.SecurityFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UpdateStudentInfoService(
    private val securityFacade: SecurityFacade,
    private val studentFacade: StudentFacade,
    private val rankFacade: RankFacade,
) {

    @Transactional
    fun execute(request: UpdateStudentInfoRequest) {
        val user = securityFacade.getCurrentUser()

        user.editName(request.name)

        val student = studentFacade.getStudentById(user.id)

        val userRank = rankFacade.getRankById(user.id)

        student.editStudentGCN(
            grade = request.grade,
            classNum = request.classNum,
            number = request.number,
        )

        userRank.editStudentInfo(
            name = request.name,
            grade = request.grade,
        )
    }
}

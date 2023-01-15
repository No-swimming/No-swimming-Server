package com.example.noswimmingserver.domain.teacher.domain

import com.example.noswimmingserver.domain.common_user.domain.User
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_teacher")
class Teacher(
    @Id
    val userId: Long,

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    subject: String?
) {

    @Column(columnDefinition = "VARCHAR(20)")
    var subject: String? = subject
        protected set

}
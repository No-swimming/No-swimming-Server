package com.example.noswimmingserver.domain.teacher.domain

import com.example.noswimmingserver.domain.common_user.domain.User
import javax.persistence.*

@Entity
@Table(name = "tbl_teacher")
class Teacher(
    @Id
    val userId: Long,

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    deviceToken: String?,

    subject: String?
) {

    @Column(columnDefinition = "VARCHAR(4096)")
    var deviceToken: String? = deviceToken
        protected set

    @Column(columnDefinition = "VARCHAR(20)")
    var subject: String? = subject
        protected set

    fun editSubject(subject: String) {
        this.subject = subject
    }

    fun saveDeviceToken(deviceToken: String) {
        this.deviceToken = deviceToken
    }

    fun queryTeacherName(): String {
        return user.name.toString()
    }
}
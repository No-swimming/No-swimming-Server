package com.example.noswimmingserver.domain.common_user.domain

import com.example.noswimmingserver.global.enum.Authority
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_user")
class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(30)", unique = true)
    val email: String,

    @Column(columnDefinition = "CHAR(60)")
    val password: String?,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(7)")
    @Enumerated(EnumType.STRING)
    val authority: Authority,

    name: String?,
) {

    @Column(columnDefinition = "VARCHAR(5)")
    var name: String? = name
        protected set

    fun editName(name: String) {
        this.name = name
    }

    fun queryName() = this.name.toString()

}
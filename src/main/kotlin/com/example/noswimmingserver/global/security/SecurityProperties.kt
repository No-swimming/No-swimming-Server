package com.example.noswimmingserver.global.security

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import java.util.*

@ConstructorBinding
@ConfigurationProperties(prefix = "jwt")
class SecurityProperties(
    accessExp: Long,
    secretKey: String
) {

    val accessExp = accessExp * 1000
    val secretKey = Base64.getEncoder().encodeToString(secretKey.toByteArray())!!
}

package com.example.noswimmingserver.global.security.jwt

import com.example.noswimmingserver.domain.common_user.presentation.dto.response.TokenResponse
import com.example.noswimmingserver.global.security.SecurityProperties
import io.jsonwebtoken.Header
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.*

@Component
class JwtProvider(
    private val securityProperties: SecurityProperties,
) {

    private fun createAccessToken(email: String) =
        Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, securityProperties.secretKey)
            .setSubject(email)
            .setHeaderParam(Header.JWT_TYPE, JwtProperty.ACCESS)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + securityProperties.accessExp))
            .compact()

    fun getToken(email: String) =
        TokenResponse(
            accessToken = createAccessToken(email),
            accessTokenExp = LocalDateTime.now().plusSeconds(securityProperties.accessExp)
        )
}

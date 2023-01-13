package com.example.noswimmingserver.global.security.jwt

import com.example.noswimmingserver.global.exception.ExpiredTokenException
import com.example.noswimmingserver.global.exception.InternalServerErrorException
import com.example.noswimmingserver.global.exception.InvalidTokenException
import com.example.noswimmingserver.global.security.SecurityProperties
import com.example.noswimmingserver.global.security.auth.AuthDetailsService
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.InvalidClaimException
import io.jsonwebtoken.Jwts
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component

@Component
class JwtParser(
    private val securityProperties: SecurityProperties,
    private val authDetailsService: AuthDetailsService
) {

    private fun getClaims(token: String): Claims {
        return try {
            Jwts.parser()
                .setSigningKey(securityProperties.secretKey)
                .parseClaimsJws(token).body
        } catch (e: Exception) {
            when (e) {
                is InvalidClaimException -> throw InvalidTokenException
                is ExpiredJwtException -> throw ExpiredTokenException
                else -> throw InternalServerErrorException
            }
        }
    }

    fun getAuthentication(token: String): Authentication {
        val claims = getClaims(token)
        val email = claims.subject
        val authDetails = authDetailsService.loadUserByUsername(email)

        return UsernamePasswordAuthenticationToken(authDetails, "", authDetails.authorities)
    }
}
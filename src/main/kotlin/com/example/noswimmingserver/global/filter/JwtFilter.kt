package com.example.noswimmingserver.global.filter

import com.example.noswimmingserver.global.security.jwt.JwtParser
import com.example.noswimmingserver.global.security.jwt.JwtProperty
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtFilter(
    private val jwtParser: JwtParser
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token = resolvedToken(request)

        token?.run {
            SecurityContextHolder.getContext().authentication = jwtParser.getAuthentication(token)
        }

        filterChain.doFilter(request, response)
    }

    private fun resolvedToken(request: HttpServletRequest): String? {
        val bearerToken = request.getHeader(JwtProperty.HEADER)

        if (bearerToken != null && bearerToken.startsWith(JwtProperty.PREFIX)) {
            return bearerToken.substring(7)
        }
        return null
    }
}
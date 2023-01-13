package com.example.noswimmingserver.global.filter

import com.example.noswimmingserver.global.error.CustomException
import com.example.noswimmingserver.global.error.response.ErrorResponse
import com.example.noswimmingserver.global.exception.InternalServerErrorException
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import java.nio.charset.StandardCharsets
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ExceptionFilter(
    private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: Exception) {
            when (e) {
                is CustomException -> setErrorJson(InternalServerErrorException, response)
                else -> setErrorJson(InternalServerErrorException, response)
            }
        }
    }

    private fun setErrorJson(e: CustomException, response: HttpServletResponse) {
        val errorResponse = ErrorResponse.of(e)

        response.characterEncoding = StandardCharsets.UTF_8.toString()
        response.status = e.status
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.writer.write(objectMapper.writeValueAsString(errorResponse))
    }

}
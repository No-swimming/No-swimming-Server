package com.example.noswimmingserver.global.filter

import com.example.noswimmingserver.global.security.jwt.JwtParser
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class FilterConfig(
    private val jwtParser: JwtParser,
    private val objectMapper: ObjectMapper
) : SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {

    override fun configure(builder: HttpSecurity) {
        builder
            .addFilterBefore(
                JwtFilter(jwtParser),
                UsernamePasswordAuthenticationFilter::class.java
            )
        builder
            .addFilterBefore(
                ExceptionFilter(objectMapper),
                JwtFilter::class.java
            )
    }
}
package com.example.noswimmingserver.global.security

import com.example.noswimmingserver.global.filter.FilterConfig
import com.example.noswimmingserver.global.security.jwt.JwtParser
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
class SecurityConfig(
    private val jwtParser: JwtParser,
    private val objectMapper: ObjectMapper
) {

    @Bean
    protected fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf().disable()
            .formLogin().disable()

            .cors()
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        http
            .authorizeRequests()

            // auth
            .antMatchers(HttpMethod.GET, "/auth/link").permitAll()
            .antMatchers(HttpMethod.GET, "/auth/google").permitAll()

            // student
            .antMatchers(HttpMethod.PUT, "/student").authenticated()
            .antMatchers(HttpMethod.DELETE, "/student").authenticated()

            .anyRequest().denyAll()

            .and().apply(FilterConfig(jwtParser, objectMapper))

        return http.build()
    }

    @Bean
    protected fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()
}
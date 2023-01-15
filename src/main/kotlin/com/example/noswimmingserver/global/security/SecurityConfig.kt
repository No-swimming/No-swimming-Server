package com.example.noswimmingserver.global.security

import com.example.noswimmingserver.global.filter.FilterConfig
import com.example.noswimmingserver.global.security.jwt.JwtParser
import com.example.noswimmingserver.global.util.AuthorityUtil
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

            // teacher
            .antMatchers(HttpMethod.POST, "/teacher").hasAuthority(AuthorityUtil.TEACHER)

            // rank
            .antMatchers(HttpMethod.GET, "/rank").permitAll()

            .anyRequest().permitAll() // TODO: 권한 한 번에 설정하기 (우선 permitAll)

            .and().apply(FilterConfig(jwtParser, objectMapper))

        return http.build()
    }

    @Bean
    protected fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()
}
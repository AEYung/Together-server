package com.aeyoung.together.global.config.security

import com.aeyoung.together.global.security.handler.CustomAccessDeniedHandler
import com.aeyoung.together.global.security.handler.CustomAuthenticationEntryPointHandler
import com.aeyoung.together.global.security.jwt.JwtExceptionFilter
import com.aeyoung.together.global.security.jwt.JwtReqFilter
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val jwtRequestFilter: JwtReqFilter,
    private val jwtExceptionFilter: JwtExceptionFilter,
    private val objectMapper: ObjectMapper,
) {
    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .cors()
            .and()
            .csrf().disable()
            .httpBasic().disable()
        http
            .authorizeHttpRequests()
            .requestMatchers("/auth/**").permitAll()
            .requestMatchers("/studies/**").authenticated()
            .requestMatchers("/rooms/**").authenticated()
            .requestMatchers("/members/**").authenticated()
            .requestMatchers("/socket/**").permitAll()
            .requestMatchers("/pub/**").permitAll()
            .requestMatchers("/sub/**").permitAll()
            .requestMatchers("/**").denyAll()
            .and()
            .exceptionHandling()
            .accessDeniedHandler(CustomAccessDeniedHandler(objectMapper))
            .authenticationEntryPoint(CustomAuthenticationEntryPointHandler(objectMapper))
            .and()
            .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter::class.java)
            .addFilterBefore(jwtExceptionFilter, JwtReqFilter::class.java)
        return http.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder(12)
    }
}
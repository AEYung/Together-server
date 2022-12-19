package com.aeyoung.together.global.security.handler

import com.aeyoung.together.global.exception.ErrorCode
import com.aeyoung.together.global.exception.ErrorResponse
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component

@Component
class CustomAuthenticationEntryPointHandler(
    private val objectMapper: ObjectMapper,
): AuthenticationEntryPoint{

    private val log = LoggerFactory.getLogger(this.javaClass.simpleName)

    override fun commence(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authException: AuthenticationException
    ) {
        log.error("==========AuthenticationEntryPoint==========")
        val errorResponse = ErrorResponse(ErrorCode.UNAUTHORIZED)
        val responseString = objectMapper!!.writeValueAsString(errorResponse)
        response.characterEncoding = "UTF-8"
        response.status = ErrorCode.UNAUTHORIZED.code
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.writer.write(responseString)
    }
}
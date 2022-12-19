package com.aeyoung.together.global.security.jwt

import com.aeyoung.together.global.exception.BasicException
import com.aeyoung.together.global.exception.ErrorCode
import com.aeyoung.together.global.exception.ErrorResponse
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtExceptionFilter(
    private val objectMapper: ObjectMapper
): OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: BasicException) {
            sendError(response, e.errorCode)
        } catch (e: Exception) {
            sendError(response, ErrorCode.INTERNAL_SERVER_ERROR)
        }
    }

    private fun sendError(res: HttpServletResponse, errorCode: ErrorCode) {
        val errorResponse = ErrorResponse(errorCode)
        val responseString = objectMapper!!.writeValueAsString(errorResponse)
        res.characterEncoding = "UTF-8"
        res.status = errorCode.code
        res.contentType = MediaType.APPLICATION_JSON_VALUE
        res.writer.write(responseString)
    }
}
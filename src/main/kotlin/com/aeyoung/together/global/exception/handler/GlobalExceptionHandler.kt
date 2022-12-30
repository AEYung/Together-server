package com.aeyoung.together.global.exception.handler

import com.aeyoung.together.global.exception.BasicException
import com.aeyoung.together.global.exception.ErrorResponse
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler{
    private val log = LoggerFactory.getLogger(this::class.simpleName)

    @ExceptionHandler(BasicException::class)
    fun basicExceptionHandling(req: HttpServletRequest, res: HttpServletResponse, ex: BasicException): ResponseEntity<ErrorResponse>{
        log.error(req.requestURI)
        log.error(ex.errorCode.msg)
        return ResponseEntity(ErrorResponse(ex.errorCode), HttpStatus.valueOf(ex.errorCode.code))
    }

    @ExceptionHandler(BindException::class)
    fun bindExceptionHandler(req: HttpServletRequest, ex: BindException): ResponseEntity<*> {
        log.error(req.requestURI)
        log.error(ex.message)
        val errorMap: MutableMap<String, String?> = HashMap()
        for (error in ex.fieldErrors) {
            errorMap[error.field] = error.defaultMessage
        }
        return ResponseEntity<Map<String, String?>>(errorMap, HttpStatus.BAD_REQUEST)
    }
}
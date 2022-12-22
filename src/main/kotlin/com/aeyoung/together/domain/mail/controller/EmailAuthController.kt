package com.aeyoung.together.domain.mail.controller

import com.aeyoung.together.domain.mail.presentation.dto.EmailAuthMailReqDto
import com.aeyoung.together.domain.mail.presentation.dto.EmailAuthReqDto
import com.aeyoung.together.domain.mail.service.EmailAuthSendingService
import com.aeyoung.together.domain.mail.service.EmailAuthVerifyingService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth/mail")
class EmailAuthController(
        val emailAuthSendingService: EmailAuthSendingService,
        val emailAuthVerifyingService: EmailAuthVerifyingService,
) {


    @PostMapping
    fun sendVerifyingMail(@RequestBody emailAuthReqDto: EmailAuthReqDto): ResponseEntity<Void> {
        emailAuthSendingService.joinEmail(emailAuthReqDto.email)
        return ResponseEntity.ok().build()
    }

    @PostMapping("/verifying")
    fun verifyAuthCode(
            @RequestBody emailAuthMailReqDto: EmailAuthMailReqDto
    ): ResponseEntity<Void> {
        emailAuthVerifyingService.execute(emailAuthMailReqDto.email, emailAuthMailReqDto.authCode)
        return ResponseEntity.ok().build()
    }
}
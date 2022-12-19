package com.aeyoung.together.domain.member.controller

import com.aeyoung.together.domain.member.dto.req.MemberSignUpReqDto
import com.aeyoung.together.domain.member.service.req.MemberSignUpService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/members")
class AuthController(
        private val memberSignUpService: MemberSignUpService
) {

    @PostMapping("/signup")
    fun signUp(@Valid @RequestBody member: MemberSignUpReqDto): ResponseEntity<Void> {
        memberSignUpService.join(member)
        return ResponseEntity.ok().build();
    }
}
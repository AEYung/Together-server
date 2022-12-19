package com.aeyoung.together.domain.member.controller

import com.aeyoung.together.domain.member.dto.req.MemberSignUpDto
import com.aeyoung.together.domain.member.service.req.MemberSignUpService
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/members/")
class AuthController(
        private val memberSignUpService: MemberSignUpService
) {

    @RequestMapping("/join")
    fun signUp(@RequestBody member: MemberSignUpDto): Long {
        return memberSignUpService.join(member)
    }
}
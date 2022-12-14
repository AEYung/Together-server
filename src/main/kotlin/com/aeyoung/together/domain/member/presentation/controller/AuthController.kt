package com.aeyoung.together.domain.member.presentation.controller

import com.aeyoung.together.domain.member.Member
import com.aeyoung.together.domain.member.presentation.dto.req.MemberSignInReqDto
import com.aeyoung.together.domain.member.presentation.dto.req.MemberSignUpReqDto
import com.aeyoung.together.domain.member.presentation.dto.res.MemberSignInResDto
import com.aeyoung.together.domain.member.presentation.dto.res.RefreshResDto
import com.aeyoung.together.domain.member.service.MemberSignInService
import com.aeyoung.together.domain.member.service.MemberSignUpService
import com.aeyoung.together.domain.member.service.RefreshService
import jakarta.validation.Valid
import org.aspectj.weaver.MemberUtils
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController(
        private val memberSignUpService: MemberSignUpService,
        private val memberSignInService: MemberSignInService,
        private val refreshService: RefreshService,
) {

    @PostMapping("/signup")
    fun signUp(@Valid @RequestBody member: MemberSignUpReqDto): ResponseEntity<Void> {
        memberSignUpService.join(member)
        return ResponseEntity.ok().build();
    }

    @PostMapping
    fun signIn(@Valid @RequestBody member: MemberSignInReqDto): ResponseEntity<MemberSignInResDto> {
        val data: MemberSignInResDto = memberSignInService.signIn(member)
        return ResponseEntity.ok(data)
    }

    @PostMapping("/refresh")
    fun refresh(@RequestHeader("RefreshToken") refreshToken: String): ResponseEntity<RefreshResDto> =
        ResponseEntity.ok(refreshService.execute(refreshToken))
}
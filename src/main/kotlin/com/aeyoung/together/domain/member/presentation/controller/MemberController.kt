package com.aeyoung.together.domain.member.presentation.controller

import com.aeyoung.together.domain.member.presentation.dto.res.MemberInfoResDto
import com.aeyoung.together.domain.member.service.GetMyInfoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/members")
class MemberController(
    private val getMyInfoService: GetMyInfoService,
){
    @GetMapping("/my")
    fun getMyInfo(): ResponseEntity<MemberInfoResDto>{
        return ResponseEntity.ok(getMyInfoService.execute())
    }
}
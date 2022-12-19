package com.aeyoung.together.domain.member.service

import com.aeyoung.together.domain.member.presentation.dto.req.MemberSignUpReqDto
import org.springframework.stereotype.Service

@Service
interface MemberSignUpService {

    fun join(memberSignUpReqDto: MemberSignUpReqDto): Long
}
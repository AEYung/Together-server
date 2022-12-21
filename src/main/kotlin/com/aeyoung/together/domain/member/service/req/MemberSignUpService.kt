package com.aeyoung.together.domain.member.service.req

import com.aeyoung.together.domain.member.dto.req.MemberSignUpReqDto
import org.springframework.stereotype.Service

@Service
interface MemberSignUpService {

    fun join(memberSignUpReqDto: MemberSignUpReqDto): Long
}
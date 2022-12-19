package com.aeyoung.together.domain.member.service.req

import com.aeyoung.together.domain.member.dto.req.MemberSignUpDto
import org.springframework.stereotype.Service

@Service
interface MemberSignUpService {

    fun join(memberSignUpDto: MemberSignUpDto): Long
}
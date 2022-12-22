package com.aeyoung.together.domain.member.service

import com.aeyoung.together.domain.member.Member
import com.aeyoung.together.domain.member.presentation.dto.req.MemberSignInReqDto
import com.aeyoung.together.domain.member.presentation.dto.res.MemberSignInResDto

interface MemberSignInService {

    fun signIn(memberSignInReqDto: MemberSignInReqDto): MemberSignInResDto

    fun getLoginMember(): Member?
}
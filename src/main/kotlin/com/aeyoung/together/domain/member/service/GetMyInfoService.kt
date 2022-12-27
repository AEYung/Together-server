package com.aeyoung.together.domain.member.service

import com.aeyoung.together.domain.member.presentation.dto.res.MemberInfoResDto

interface GetMyInfoService {
    fun execute(): MemberInfoResDto
}
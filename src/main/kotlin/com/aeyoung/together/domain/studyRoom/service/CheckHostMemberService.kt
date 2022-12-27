package com.aeyoung.together.domain.studyRoom.service

import com.aeyoung.together.domain.studyRoom.presentation.dto.res.CheckHostMemberResDto

interface CheckHostMemberService {
    fun execute(studyId: Long): CheckHostMemberResDto
}
package com.aeyoung.together.domain.studyRoom.service

import com.aeyoung.together.domain.studyRoom.presentation.dto.res.HostRoomInfoResDto
import com.aeyoung.together.domain.studyRoom.presentation.dto.res.MemberRoomInfoResDto

interface GetMemberStudyInfoService {

    fun execute(studyId: Long): MemberRoomInfoResDto
}
package com.aeyoung.together.domain.studyRoom.service

import com.aeyoung.together.domain.studyRoom.presentation.dto.res.HostRoomInfoResDto

interface GetHostStudyInfoService {

    fun execute(studyId: Long):HostRoomInfoResDto
}
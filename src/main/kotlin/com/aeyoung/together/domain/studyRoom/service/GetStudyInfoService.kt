package com.aeyoung.together.domain.studyRoom.service

import com.aeyoung.together.domain.studyRoom.presentation.dto.res.GetRoomInfoResDto

interface GetStudyInfoService {

    fun execute(studyId: Long):GetRoomInfoResDto
}
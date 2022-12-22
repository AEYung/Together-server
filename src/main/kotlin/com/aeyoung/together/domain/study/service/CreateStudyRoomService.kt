package com.aeyoung.together.domain.study.service

import com.aeyoung.together.domain.study.StudyRoom
import com.aeyoung.together.domain.study.presentation.dto.req.CreateStudyRoomReqDto

interface CreateStudyRoomService {

    fun createStudyRoom(createStudyRoomReqDto: CreateStudyRoomReqDto):StudyRoom
}
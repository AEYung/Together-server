package com.aeyoung.together.domain.studyRoom.service

import com.aeyoung.together.domain.studyRoom.presentation.dto.req.UpdateStudyRoomReqDto

interface UpdateStudyRoomService {

    fun execute(updateStudyRoomReqDto: UpdateStudyRoomReqDto, studyRoomId: Long)
}
package com.aeyoung.together.domain.studyRoom.service

import com.aeyoung.together.domain.studyRoom.presentation.dto.req.WriteNoticeReqDto

interface WriteNoticeService {

    fun execute(writeNoticeReqDto: WriteNoticeReqDto, studyId: Long)
}
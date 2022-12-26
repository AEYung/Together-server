package com.aeyoung.together.domain.study.service

import com.aeyoung.together.domain.study.presentation.dto.req.WriteNoticeReqDto

interface WriteNoticeService {

    fun execute(writeNoticeReqDto: WriteNoticeReqDto, studyId: Long)
}
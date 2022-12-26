package com.aeyoung.together.domain.studyRoom.service

import com.aeyoung.together.domain.studyRoom.presentation.dto.req.WriteNoticeCommentReqDto

interface WriteNoticeCommentService {

    fun execute(writeNoticeCommentReqDto: WriteNoticeCommentReqDto, noticeId:Long)
}
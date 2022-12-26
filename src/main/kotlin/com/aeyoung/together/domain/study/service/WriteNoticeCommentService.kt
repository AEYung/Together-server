package com.aeyoung.together.domain.study.service

import com.aeyoung.together.domain.study.presentation.dto.req.WriteNoticeCommentReqDto

interface WriteNoticeCommentService {

    fun execute(writeNoticeCommentReqDto: WriteNoticeCommentReqDto)
}
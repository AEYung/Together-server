package com.aeyoung.together.domain.study.service

import com.aeyoung.together.domain.study.presentation.dto.req.ApplyPermissionStudyReqDto

interface ApplyStudyService {
    fun execute(id: Long, applyPermissionStudyReqDto: ApplyPermissionStudyReqDto)
    fun execute(id: Long)
    fun execute(id: Long, code: String)
}
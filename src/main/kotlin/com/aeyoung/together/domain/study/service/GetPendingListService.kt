package com.aeyoung.together.domain.study.service

import com.aeyoung.together.domain.study.presentation.dto.res.PendingListResDto

interface GetPendingListService {
    fun execute(id: Long): PendingListResDto
}
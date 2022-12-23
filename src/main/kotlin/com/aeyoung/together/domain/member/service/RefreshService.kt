package com.aeyoung.together.domain.member.service

import com.aeyoung.together.domain.member.presentation.dto.res.RefreshResDto

interface RefreshService {
    fun execute(refreshToken: String): RefreshResDto
}
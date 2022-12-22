package com.aeyoung.together.domain.study.service

import com.aeyoung.together.domain.study.presentation.dto.res.StudyListResDto

interface GetAllStudyService {
    fun execute(): StudyListResDto
}
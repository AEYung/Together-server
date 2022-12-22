package com.aeyoung.together.domain.study.service

import com.aeyoung.together.domain.study.presentation.dto.res.StudyResDto

interface GetOneStudyService {
    fun execute(id: Long): StudyResDto
}
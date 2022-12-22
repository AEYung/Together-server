package com.aeyoung.together.domain.study.service

import com.aeyoung.together.domain.study.presentation.dto.res.StudyListResDto

interface SearchStudyService {
    fun execute(searchArgument: String): StudyListResDto
}
package com.aeyoung.together.domain.study.service.impl

import com.aeyoung.together.domain.study.presentation.dto.res.StudyListResDto
import com.aeyoung.together.domain.study.presentation.dto.res.StudyResDto
import com.aeyoung.together.domain.study.repository.StudyRoomRepository
import com.aeyoung.together.domain.study.service.SearchStudyService
import com.aeyoung.together.domain.study.util.StudyTagUtil
import org.springframework.stereotype.Service

@Service
class SearchStudyServiceImpl(
    private val studyRoomRepository: StudyRoomRepository,
    private val studyTagUtil: StudyTagUtil,
): SearchStudyService{
    override fun execute(searchArgument: String): StudyListResDto =
        StudyListResDto(
            list = studyRoomRepository.findAll()
                .filter {
                    (it.description != null&& it.description.contains(searchArgument))
                    || it.title.contains(searchArgument)
                    || studyTagUtil.isContainTag(it.tags, searchArgument)
                }
                .map { StudyResDto(it) }
        )
}
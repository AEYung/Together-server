package com.aeyoung.together.domain.study.service.impl

import com.aeyoung.together.domain.study.presentation.dto.res.StudyListResDto
import com.aeyoung.together.domain.study.presentation.dto.res.StudyResDto
import com.aeyoung.together.domain.study.repository.StudyRoomRepository
import com.aeyoung.together.domain.study.service.GetAllStudyService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GetAllStudyServiceImpl(
    private val studyRoomRepository: StudyRoomRepository
): GetAllStudyService {
    @Transactional(readOnly = true, rollbackFor = [Exception::class])
    override fun execute(): StudyListResDto =
        StudyListResDto(
            list = studyRoomRepository.findAll()
                .map { StudyResDto(it) }
        )

}
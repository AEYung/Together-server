package com.aeyoung.together.domain.study.service.impl

import com.aeyoung.together.domain.study.exception.StudyNotFoundException
import com.aeyoung.together.domain.study.presentation.dto.res.StudyResDto
import com.aeyoung.together.domain.study.repository.StudyRoomRepository
import com.aeyoung.together.domain.study.service.GetOneStudyService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GetOneStudyServiceImpl(
    private val studyRoomRepository: StudyRoomRepository,
): GetOneStudyService {
    @Transactional(readOnly = true, rollbackFor = [Exception::class])
    override fun execute(id: Long): StudyResDto {
        return StudyResDto(
            studyRoom = studyRoomRepository.findById(id)
                .orElseThrow{ throw StudyNotFoundException()}
        )
    }
}
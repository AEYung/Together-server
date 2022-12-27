package com.aeyoung.together.domain.studyRoom.service.impl

import com.aeyoung.together.domain.study.exception.StudyNotFoundException
import com.aeyoung.together.domain.study.repository.StudyRoomRepository
import com.aeyoung.together.domain.studyRoom.presentation.dto.res.GetRoomInfoResDto
import com.aeyoung.together.domain.studyRoom.service.GetStudyInfoService
import org.springframework.stereotype.Service

@Service
class GetStudyInfoServiceImpl(
    val studyRoomRepository: StudyRoomRepository
) : GetStudyInfoService {
    override fun execute(studyId: Long): GetRoomInfoResDto = GetRoomInfoResDto(
        studyRoom = studyRoomRepository.findById(studyId)
            .orElseThrow { throw StudyNotFoundException() }
    )
}
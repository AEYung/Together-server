package com.aeyoung.together.domain.studyRoom.service.impl

import com.aeyoung.together.domain.study.exception.StudyNotFoundException
import com.aeyoung.together.domain.study.repository.StudyRoomRepository
import com.aeyoung.together.domain.studyRoom.presentation.dto.res.MemberRoomInfoResDto
import com.aeyoung.together.domain.studyRoom.service.GetMemberStudyInfoService
import org.springframework.stereotype.Service

@Service
class GetMemberStudyInfoServiceImpl(
    val studyRoomRepository: StudyRoomRepository,
) : GetMemberStudyInfoService {
    override fun execute(studyId: Long): MemberRoomInfoResDto {
        val studyRoom = studyRoomRepository.findById(studyId)
            .orElseThrow { throw StudyNotFoundException() }
        return MemberRoomInfoResDto(
            studyRoom = studyRoom
        )
    }
}
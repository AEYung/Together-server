package com.aeyoung.together.domain.studyRoom.service.impl

import com.aeyoung.together.domain.study.exception.MemberNotHostException
import com.aeyoung.together.domain.study.exception.StudyNotFoundException
import com.aeyoung.together.domain.study.repository.StudyRoomRepository
import com.aeyoung.together.domain.studyRoom.presentation.dto.res.HostRoomInfoResDto
import com.aeyoung.together.domain.studyRoom.service.GetHostStudyInfoService
import com.aeyoung.together.global.util.MemberUtil
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GetHostStudyInfoServiceImpl(
    val studyRoomRepository: StudyRoomRepository,
    val memberUtil: MemberUtil
) : GetHostStudyInfoService {
    
    @Transactional(rollbackFor = [Exception::class])
    override fun execute(studyId: Long): HostRoomInfoResDto {
        val studyRoom = studyRoomRepository.findById(studyId)
            .orElseThrow { throw StudyNotFoundException() }
        if (studyRoom.host == memberUtil.currentMember()) {
            return HostRoomInfoResDto(
                studyRoom = studyRoom
            )
        }
        throw MemberNotHostException()
    }
}
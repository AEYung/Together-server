package com.aeyoung.together.domain.study.service.impl

import com.aeyoung.together.domain.study.StudyNotice
import com.aeyoung.together.domain.study.exception.StudyNotFoundException
import com.aeyoung.together.domain.study.presentation.dto.req.WriteNoticeReqDto
import com.aeyoung.together.domain.study.repository.StudyNoticeRepository
import com.aeyoung.together.domain.study.repository.StudyRoomRepository
import com.aeyoung.together.domain.study.service.WriteNoticeService
import com.aeyoung.together.global.util.MemberUtil
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class WriteNoticeServiceImpl(
    val memberUtil: MemberUtil,
    val studyRoomRepository: StudyRoomRepository,
    val studyNoticeRepository: StudyNoticeRepository
) : WriteNoticeService {
    override fun execute(writeNoticeReqDto: WriteNoticeReqDto, studyId: Long) {
        val studyRoom = studyRoomRepository.findById(studyId).orElseThrow { throw StudyNotFoundException() }
        val studyNotice = writeNoticeReqDto.toEntity(memberUtil.currentMember(), studyRoom)

        studyNoticeRepository.save(studyNotice)
    }
}
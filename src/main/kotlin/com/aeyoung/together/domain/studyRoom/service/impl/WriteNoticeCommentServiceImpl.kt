package com.aeyoung.together.domain.studyRoom.service.impl

import com.aeyoung.together.domain.studyRoom.exception.StudyNoticeNotFoundException
import com.aeyoung.together.domain.studyRoom.presentation.dto.req.WriteNoticeCommentReqDto
import com.aeyoung.together.domain.studyRoom.repository.StudyNoticeCommentRepository
import com.aeyoung.together.domain.studyRoom.repository.StudyNoticeRepository
import com.aeyoung.together.domain.studyRoom.service.WriteNoticeCommentService
import com.aeyoung.together.global.util.MemberUtil
import org.springframework.stereotype.Service

@Service
class WriteNoticeCommentServiceImpl(
    val studyNoticeRepository: StudyNoticeRepository,
    val studyNoticeCommentRepository: StudyNoticeCommentRepository,
    val memberUtil: MemberUtil
) : WriteNoticeCommentService {
    override fun execute(writeNoticeCommentReqDto: WriteNoticeCommentReqDto, noticeId: Long) {
        val studyNotice = studyNoticeRepository.findById(noticeId).orElseThrow { throw StudyNoticeNotFoundException() }
        val noticeComment = writeNoticeCommentReqDto.toEntity(studyNotice, memberUtil.currentMember())

        studyNoticeCommentRepository.save(noticeComment)
    }
}
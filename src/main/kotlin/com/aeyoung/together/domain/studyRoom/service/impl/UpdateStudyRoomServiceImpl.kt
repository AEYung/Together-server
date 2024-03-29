package com.aeyoung.together.domain.studyRoom.service.impl

import com.aeyoung.together.domain.study.StudyRoom
import com.aeyoung.together.domain.study.StudyTag
import com.aeyoung.together.domain.study.enums.StudyRoomScope
import com.aeyoung.together.domain.study.exception.MemberNotHostException
import com.aeyoung.together.domain.study.exception.StudyNotFoundException
import com.aeyoung.together.domain.study.repository.StudyRoomRepository
import com.aeyoung.together.domain.study.repository.StudyTagRepository
import com.aeyoung.together.domain.studyRoom.presentation.dto.req.UpdateStudyRoomReqDto
import com.aeyoung.together.domain.studyRoom.service.UpdateStudyRoomService
import com.aeyoung.together.global.util.MemberUtil
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class UpdateStudyRoomServiceImpl(
    val studyRoomRepository: StudyRoomRepository,
    val memberUtil: MemberUtil,
    val studyTagRepository: StudyTagRepository
) : UpdateStudyRoomService {

    @Transactional(rollbackFor = [Exception::class])
    override fun execute(updateStudyRoomReqDto: UpdateStudyRoomReqDto, studyRoomId: Long) {

        val updatingStudyRoom = studyRoomRepository.findById(studyRoomId)
            .orElseThrow { throw StudyNotFoundException() }

        if (memberUtil.currentMember().id != updatingStudyRoom.host.id)
            throw MemberNotHostException()

        val tags = mutableListOf<StudyTag>()
        for (i in updateStudyRoomReqDto.tags) {
            val studyTag: StudyTag = studyTagRepository.findByContent(i) ?: studyTagRepository.save(StudyTag(i))
            tags.add(studyTag)
        }
        val studyRoom: StudyRoom =
            if (updateStudyRoomReqDto.scope == StudyRoomScope.PRIVATE) {
                val code = UUID.randomUUID().toString().split("-")[0]
                updateStudyRoomReqDto.toEntity(updatingStudyRoom.host, tags, code)
            } else
                updateStudyRoomReqDto.toEntity(updatingStudyRoom.host, tags)

        updatingStudyRoom.members.forEach {
            if (!studyRoom.members.contains(it))
                studyRoom.members.add(it)
        }

        updatingStudyRoom.studyNotices.forEach {
            if (!studyRoom.studyNotices.contains(it))
                studyRoom.studyNotices.add(it)
        }
        studyRoom.id = updatingStudyRoom.id
        studyRoomRepository.save(studyRoom)
    }


}
package com.aeyoung.together.domain.study.service.impl

import com.aeyoung.together.domain.member.exception.NotExistLoginMemberException
import com.aeyoung.together.domain.study.StudyRoom
import com.aeyoung.together.domain.study.StudyTag
import com.aeyoung.together.domain.study.enums.StudyRoomScope
import com.aeyoung.together.domain.study.presentation.dto.req.CreateStudyRoomReqDto
import com.aeyoung.together.domain.study.repository.StudyRoomRepository
import com.aeyoung.together.domain.study.repository.StudyTagRepository
import com.aeyoung.together.domain.study.service.CreateStudyRoomService
import com.aeyoung.together.global.util.MemberUtil
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class CreateStudyRoomServiceImpl(
    val studyRoomRepository: StudyRoomRepository,
    val studyTagRepository: StudyTagRepository,
    val memberUtil: MemberUtil
) : CreateStudyRoomService {

    @Transactional(rollbackFor = [Exception::class])
    override fun createStudyRoom(createStudyRoomReqDto: CreateStudyRoomReqDto): StudyRoom {
        val host = memberUtil.currentMember() ?: throw NotExistLoginMemberException()
        val studyTags: MutableList<StudyTag> = mutableListOf()
        if (createStudyRoomReqDto.tags != null) {
            for (i in createStudyRoomReqDto.tags) {
                val studyTag: StudyTag = studyTagRepository.findByContent(i) ?: studyTagRepository.save(StudyTag(i))
                studyTags.add(studyTag)
            }
        }
        val studyRoom: StudyRoom =
            if(createStudyRoomReqDto.scope == StudyRoomScope.PRIVATE){
                val code = UUID.randomUUID().toString().split("-")[0]
                createStudyRoomReqDto.toEntity(host, studyTags, code)
            } else
                createStudyRoomReqDto.toEntity(host, studyTags)
        studyRoomRepository.save(studyRoom)
        return studyRoom
    }
}
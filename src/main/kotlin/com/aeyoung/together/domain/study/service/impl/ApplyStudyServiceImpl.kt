package com.aeyoung.together.domain.study.service.impl

import com.aeyoung.together.domain.study.PendingUser
import com.aeyoung.together.domain.study.enums.StudyRoomScope
import com.aeyoung.together.domain.study.exception.RoomCodeNotMatchException
import com.aeyoung.together.domain.study.exception.RoomScopeNotValidException
import com.aeyoung.together.domain.study.exception.StudyNotFoundException
import com.aeyoung.together.domain.study.presentation.dto.req.ApplyPermissionStudyReqDto
import com.aeyoung.together.domain.study.repository.PendingUserRepository
import com.aeyoung.together.domain.study.repository.StudyRoomRepository
import com.aeyoung.together.domain.study.service.ApplyStudyService
import com.aeyoung.together.global.util.MemberUtil
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
@Transactional(rollbackFor = [Exception::class])
class ApplyStudyServiceImpl(
    private val studyRoomRepository: StudyRoomRepository,
    private val pendingUserRepository: PendingUserRepository,
    private val memberUtil: MemberUtil,
): ApplyStudyService {

    override fun execute(id: Long, applyPermissionStudyReqDto: ApplyPermissionStudyReqDto) {
        val studyRoom = studyRoomRepository.findById(id)
            .orElseThrow { throw StudyNotFoundException() }
        if(studyRoom.scope != StudyRoomScope.PERMISSION)
            throw RoomScopeNotValidException()
        val member = memberUtil.currentMember()
        pendingUserRepository.save(
            PendingUser(
                id = UUID.randomUUID().toString(),
                studyId = studyRoom.id,
                answer = applyPermissionStudyReqDto.answer,
                memberId = member.id
            )
        )
    }

    override fun execute(id: Long) {
        val studyRoom = studyRoomRepository.findById(id)
            .orElseThrow { throw StudyNotFoundException() }
        if(studyRoom.scope != StudyRoomScope.PUBLIC)
            throw RoomScopeNotValidException()
        val member = memberUtil.currentMember()
        studyRoom.members.add(member)
        member.studyList.add(studyRoom)
    }

    override fun execute(id: Long, code: String) {
        val studyRoom = studyRoomRepository.findById(id)
            .orElseThrow { throw StudyNotFoundException() }
        if(studyRoom.scope != StudyRoomScope.PRIVATE)
            throw RoomScopeNotValidException()
        if(studyRoom.code != code)
            throw RoomCodeNotMatchException()
        val member = memberUtil.currentMember()
        studyRoom.members.add(member)
        member.studyList.add(studyRoom)
    }
}
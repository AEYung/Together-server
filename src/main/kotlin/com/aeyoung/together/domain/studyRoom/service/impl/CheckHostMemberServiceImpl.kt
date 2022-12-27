package com.aeyoung.together.domain.studyRoom.service.impl

import com.aeyoung.together.domain.member.exception.MemberNotFoundException
import com.aeyoung.together.domain.study.exception.MemberNotHostException
import com.aeyoung.together.domain.study.repository.StudyRoomRepository
import com.aeyoung.together.domain.studyRoom.presentation.dto.res.CheckHostMemberResDto
import com.aeyoung.together.domain.studyRoom.service.CheckHostMemberService
import com.aeyoung.together.global.util.MemberUtil
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CheckHostMemberServiceImpl(
    val memberUtil: MemberUtil,
    val studyRoomRepository: StudyRoomRepository
) : CheckHostMemberService {
    @Transactional(rollbackFor = [Exception::class], readOnly = true)
    override fun execute(studyId: Long): CheckHostMemberResDto {
        val checkMember = memberUtil.currentMember()
        val hostMember = studyRoomRepository.findById(studyId).orElseThrow { throw MemberNotFoundException() }
        if (checkMember.id == hostMember.id)
            return CheckHostMemberResDto(
                isHost = true
            )
        return CheckHostMemberResDto(
            isHost = false
        )
    }


}
package com.aeyoung.together.domain.study.service.impl

import com.aeyoung.together.domain.member.exception.MemberNotFoundException
import com.aeyoung.together.domain.member.repository.MemberRepository
import com.aeyoung.together.domain.study.exception.MemberNotHostException
import com.aeyoung.together.domain.study.exception.StudyNotFoundException
import com.aeyoung.together.domain.study.repository.PendingUserRepository
import com.aeyoung.together.domain.study.repository.StudyRoomRepository
import com.aeyoung.together.domain.study.service.ApproveStudyMemberService
import com.aeyoung.together.global.util.MemberUtil
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(rollbackFor = [Exception::class])
class ApproveStudyMemberServiceImpl(
    private val memberRepository: MemberRepository,
    private val studyRoomRepository: StudyRoomRepository,
    private val pendingUserRepository: PendingUserRepository,
    private val memberUtil: MemberUtil,
): ApproveStudyMemberService{
    override fun execute(id: String) {
        val pendingUser = pendingUserRepository.findById(id)
            .orElseThrow { throw Exception() }
        val studyRoom = studyRoomRepository.findById(pendingUser.studyId)
            .orElseThrow { throw StudyNotFoundException() }
        if(studyRoom.host != memberUtil.currentMember())
            throw MemberNotHostException()
        val member = memberRepository.findById(pendingUser.memberId)
            .orElseThrow { throw MemberNotFoundException() }
        studyRoom.members.add(member)
        member.studyList.add(studyRoom)
        pendingUserRepository.delete(pendingUser)
    }
}
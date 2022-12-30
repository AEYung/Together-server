package com.aeyoung.together.domain.member.service.impl

import com.aeyoung.together.domain.member.presentation.dto.res.InfoStudyResDto
import com.aeyoung.together.domain.member.presentation.dto.res.MemberInfoResDto
import com.aeyoung.together.domain.member.service.GetMyInfoService
import com.aeyoung.together.domain.study.StudyRoom
import com.aeyoung.together.domain.study.exception.StudyNotFoundException
import com.aeyoung.together.domain.study.repository.PendingUserRepository
import com.aeyoung.together.domain.study.repository.StudyRoomRepository
import com.aeyoung.together.global.util.MemberUtil
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.Exception

@Service
@Transactional(readOnly = true, rollbackFor = [Exception::class])
class GetMyInfoServiceImpl(
    private val memberUtil: MemberUtil,
    private val studyRoomRepository: StudyRoomRepository,
    private val pendingUserRepository: PendingUserRepository,
): GetMyInfoService{
    override fun execute(): MemberInfoResDto {
        val member = memberUtil.currentMember()
        val lists = mutableListOf<StudyRoom>()
        pendingUserRepository.findAll()
            .filter { member.id == it.memberId }
            .let {
                it.forEach { val studyRoom = studyRoomRepository.findById(it.studyId)
                    .orElseThrow { throw StudyNotFoundException() }
                    lists.add(studyRoom)
                }
            }
        return MemberInfoResDto(
            id = member.id,
            name = member.name,
            studyList = member.studyList.map { InfoStudyResDto(it, member) },
            pendingStudyList = lists.map { InfoStudyResDto(it, member) },
        )
    }
}
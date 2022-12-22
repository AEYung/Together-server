package com.aeyoung.together.global.util

import com.aeyoung.together.domain.member.Member
import com.aeyoung.together.domain.member.exception.NotExistLoginMemberException
import com.aeyoung.together.domain.member.repository.MemberRepository
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class MemberUtil(private val memberRepository: MemberRepository) {

    fun currentMember(): Member {
        val email = SecurityContextHolder.getContext().authentication.name
        println(email)
        if (memberRepository.findMemberByEmail(email) == null) {
            throw NotExistLoginMemberException()
        }
        return memberRepository.findMemberByEmail(email)!!
    }
}
package com.aeyoung.together.domain.member.repository

import com.aeyoung.together.domain.member.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository: JpaRepository<Member, Long> {
    fun findMemberByEmail(email: String): Member?
    fun existsByEmail(email: String): Boolean
}
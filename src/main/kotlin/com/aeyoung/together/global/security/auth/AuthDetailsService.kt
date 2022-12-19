package com.aeyoung.together.global.security.auth

import com.aeyoung.together.domain.member.repository.MemberRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class AuthDetailsService(
    private val memberRepository: MemberRepository,
): UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = memberRepository.findByEmail(username) ?: throw RuntimeException()
        return AuthDetails(user)
    }

}
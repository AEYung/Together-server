package com.aeyoung.together.domain.member.service.impl

import com.aeyoung.together.domain.member.presentation.dto.req.MemberSignUpReqDto
import com.aeyoung.together.domain.member.repository.MemberRepository
import com.aeyoung.together.domain.member.service.MemberSignUpService
import com.aeyoung.together.domain.member.exception.DuplicatedEmailException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class MemberSignUpServiceImpl(
        val memberRepository: MemberRepository,
        val passwordEncoder: PasswordEncoder
) : MemberSignUpService {

    override fun join(
        memberSignUpReqDto: MemberSignUpReqDto,
    ): Long {
        if (memberRepository.existsByEmail(memberSignUpReqDto.email))
            throw DuplicatedEmailException()
        val member = memberSignUpReqDto.toEntity(passwordEncoder.encode(memberSignUpReqDto.password));
        return memberRepository.save(member).id
    }


}
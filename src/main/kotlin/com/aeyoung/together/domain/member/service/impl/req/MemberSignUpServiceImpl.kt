package com.aeyoung.together.domain.member.service.impl.req

import com.aeyoung.together.domain.member.dto.req.MemberSignUpReqDto
import com.aeyoung.together.domain.member.repository.MemberRepository
import com.aeyoung.together.domain.member.service.req.MemberSignUpService
import com.aeyoung.together.global.exception.DuplicatedEmailException
import com.aeyoung.together.global.exception.ErrorCode
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
        if (memberRepository.existsByEmail(memberSignUpReqDto.email)) {
            throw DuplicatedEmailException(ErrorCode.DUPLICATE_EMAIL)
        }
        val member = memberSignUpReqDto.toEntity(passwordEncoder.encode(memberSignUpReqDto.password));
        return memberRepository.save(member).id
    }
}
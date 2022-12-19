package com.aeyoung.together.domain.member.service.req.impl

import com.aeyoung.together.domain.member.dto.req.MemberSignUpDto
import com.aeyoung.together.domain.member.repository.MemberRepository
import com.aeyoung.together.domain.member.service.req.MemberSignUpService
import com.aeyoung.together.global.exception.BasicException
import com.aeyoung.together.global.exception.DuplicatedEmailException
import com.aeyoung.together.global.exception.ErrorCode
import com.aeyoung.together.global.exception.ErrorResponse
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class MemberSignUpServiceImpl(
        val memberRepository: MemberRepository,
        val passwordEncoder: PasswordEncoder
) : MemberSignUpService {

    override fun join(
            memberSignUpDto: MemberSignUpDto,
    ): Long {
        if (memberRepository.findByEmail(memberSignUpDto.email)!=null) {
            throw DuplicatedEmailException(ErrorCode.DUPLICATE_EMAIL)
        }
        val encodedPassword = passwordEncoder.encode(memberSignUpDto.password)
        val member = memberSignUpDto.toEntity(encodedPassword);
        return memberRepository.save(member).id
    }


}
package com.aeyoung.together.domain.member.service.impl

import DuplicatedEmailException
import com.aeyoung.together.domain.mail.exception.NotCheckedEmailException
import com.aeyoung.together.domain.mail.repository.EmailAuthRepository
import com.aeyoung.together.domain.member.presentation.dto.req.MemberSignUpReqDto
import com.aeyoung.together.domain.member.repository.MemberRepository
import com.aeyoung.together.domain.member.service.MemberSignUpService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class MemberSignUpServiceImpl(
        val memberRepository: MemberRepository,
        val passwordEncoder: PasswordEncoder,
        val emailAuthRepository: EmailAuthRepository,
) : MemberSignUpService {

    override fun join(
            memberSignUpReqDto: MemberSignUpReqDto,
    ): Long {
        if (memberRepository.existsByEmail(memberSignUpReqDto.email)) {
            throw DuplicatedEmailException()
        }
        val emailAuth = emailAuthRepository.findById(memberSignUpReqDto.email).orElseThrow { NotCheckedEmailException() }
        if (!emailAuth.isChecked) {
            throw NotCheckedEmailException();
        }
        val member = memberSignUpReqDto.toEntity(passwordEncoder.encode(memberSignUpReqDto.password));
        return memberRepository.save(member).id
    }
}
package com.aeyoung.together.domain.member.service.impl.req

import com.aeyoung.together.domain.member.dto.req.MemberSignUpReqDto
import com.aeyoung.together.domain.member.repository.MemberRepository
import com.aeyoung.together.domain.member.service.req.MemberSignUpService
import com.aeyoung.together.global.exception.DuplicatedEmailException
import com.aeyoung.together.global.exception.ErrorCode
import com.aeyoung.together.global.exception.NotCheckedEmailException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class MemberSignUpServiceImpl(
        val memberRepository: MemberRepository,
        val passwordEncoder: PasswordEncoder,
) : MemberSignUpService {

    var isCheckedEmail: Boolean = false;
    override fun setIsCheckedEmail(isChecked: Boolean) {
        isCheckedEmail = isChecked
    }

    override fun join(
            memberSignUpReqDto: MemberSignUpReqDto,
    ): Long {
        if (memberRepository.existsByEmail(memberSignUpReqDto.email)) {
            throw DuplicatedEmailException(ErrorCode.DUPLICATE_EMAIL)
        }
        if () {
            throw NotCheckedEmailException()
        }
        val member = memberSignUpReqDto.toEntity(passwordEncoder.encode(memberSignUpReqDto.password));
        return memberRepository.save(member).id
    }
}
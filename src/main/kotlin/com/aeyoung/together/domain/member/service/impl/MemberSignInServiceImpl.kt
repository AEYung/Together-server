package com.aeyoung.together.domain.member.service.impl

import com.aeyoung.together.domain.member.Member
import com.aeyoung.together.domain.member.entity.RefreshToken
import com.aeyoung.together.domain.member.exception.MemberNotFoundException
import com.aeyoung.together.domain.member.exception.WrongPasswordException
import com.aeyoung.together.domain.member.presentation.dto.req.MemberSignInReqDto
import com.aeyoung.together.domain.member.presentation.dto.res.MemberSignInResDto
import com.aeyoung.together.domain.member.repository.MemberRepository
import com.aeyoung.together.domain.member.repository.RefreshTokenRepository
import com.aeyoung.together.domain.member.service.MemberSignInService
import com.aeyoung.together.global.security.jwt.TokenProvider
import com.aeyoung.together.global.util.MemberUtil
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class MemberSignInServiceImpl(
        val refreshTokenRepository: RefreshTokenRepository,
        val memberRepository: MemberRepository,
        val passwordEncoder: PasswordEncoder,
        val tokenProvider: TokenProvider,
        val memberUtil: MemberUtil
) : MemberSignInService {

    @Transactional
    override fun signIn(req: MemberSignInReqDto): MemberSignInResDto {
        val member = memberRepository.findMemberByEmail(req.email) ?: throw MemberNotFoundException()
        if (!passwordEncoder.matches(req.password, member.password)) {
            throw WrongPasswordException()
        }
        val accessToken = tokenProvider.generateAccessToken(req.email)
        val refreshToken = tokenProvider.generateRefreshToken(req.email)
        val entityToRedis = RefreshToken(req.email, refreshToken, TokenProvider.REFRESH_EXP)
        refreshTokenRepository.save(entityToRedis)

        return MemberSignInResDto(
                accessToken = accessToken,
                refreshToken = refreshToken,
                expiredAt = tokenProvider.accessExpiredTime
        )
    }

    override fun getLoginMember(): Member? {
        return memberUtil.currentMember()
    }
}
package com.aeyoung.together.domain.member.service.impl

import com.aeyoung.together.domain.member.entity.RefreshToken
import com.aeyoung.together.domain.member.exception.MemberNotFoundException
import com.aeyoung.together.domain.member.exception.RefreshTokenExpiredException
import com.aeyoung.together.domain.member.exception.RefreshTokenNotValidException
import com.aeyoung.together.domain.member.presentation.dto.res.RefreshResDto
import com.aeyoung.together.domain.member.repository.MemberRepository
import com.aeyoung.together.domain.member.repository.RefreshTokenRepository
import com.aeyoung.together.domain.member.service.RefreshService
import com.aeyoung.together.global.security.jwt.TokenProvider
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RefreshServiceImpl(
    private val tokenProvider: TokenProvider,
    private val memberRepository: MemberRepository,
    private val refreshTokenRepository: RefreshTokenRepository,
): RefreshService{
    @Transactional(rollbackFor = [Exception::class])
    override fun execute(refreshToken: String): RefreshResDto{
        val parseToken = tokenProvider.parseToken(refreshToken)
            ?: throw RefreshTokenNotValidException()
        val email = tokenProvider.exactEmailFromRefreshToken(parseToken)
        println("test1")
        val newRefreshToken = refreshTokenRepository.findRefreshTokenByEmail(email)
            ?: throw RefreshTokenExpiredException()
        println("test")
        if(newRefreshToken.token != parseToken)
            throw RefreshTokenNotValidException()
        if(!memberRepository.existsByEmail(email))
            throw MemberNotFoundException()
        val accessToken = tokenProvider.generateAccessToken(email)
        val refreshToken = tokenProvider.generateRefreshToken(email)
        refreshTokenRepository.save(
            RefreshToken(
                email = email,
                token = refreshToken,
            )
        )
        return RefreshResDto(
            accessToken = accessToken,
            refreshToken = refreshToken,
            expiredAt = tokenProvider.accessExpiredTime
        )
    }
}
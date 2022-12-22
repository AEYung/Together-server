package com.aeyoung.together.domain.member.repository

import com.aeyoung.together.domain.member.entity.RefreshToken
import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository : CrudRepository<RefreshToken, String> {
    fun findRefreshTokenByEmail(email: String): RefreshToken?

    fun findEmailByRefreshToken(refreshToken: String): String
}
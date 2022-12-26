package com.aeyoung.together.domain.member.entity

import com.aeyoung.together.global.security.jwt.TokenProvider
import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import org.springframework.data.redis.core.index.Indexed

@RedisHash(value = "refreshToken", timeToLive = TokenProvider.REFRESH_EXP)
class RefreshToken(
        @Id
        @Indexed
        private var email: String,
        var token: String,
)
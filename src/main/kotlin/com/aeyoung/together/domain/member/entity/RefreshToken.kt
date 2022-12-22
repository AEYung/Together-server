package com.aeyoung.together.domain.member.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import org.springframework.data.redis.core.index.Indexed

@RedisHash(value = "refreshToken")
class RefreshToken(
        @Id
        private var email: String,
        @Indexed
        var token: String,
        @TimeToLive
        private var expiredAt: Long
)
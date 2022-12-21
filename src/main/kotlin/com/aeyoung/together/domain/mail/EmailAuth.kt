package com.aeyoung.together.domain.mail

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash(value = "EmailAuthCode", timeToLive = 300)
class EmailAuth(
        @Id
        val email: String,
        val authCode: Int
)

package com.aeyoung.together.domain.study

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash(value = "pendingUser")
class PendingUser(
    @Id
    val id: String,
    val studyId: Long,
    val answer: String,
    val memberId: Long,
)
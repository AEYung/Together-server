package com.aeyoung.together.domain.study.presentation.dto.res

import com.aeyoung.together.domain.study.PendingUser

class PendingResDto(
    val id: String,
    val answer: String,
    val memberId: Long,
){
    constructor(pendingUser: PendingUser): this(
        id = pendingUser.id,
        answer = pendingUser.answer,
        memberId = pendingUser.memberId
    )
}
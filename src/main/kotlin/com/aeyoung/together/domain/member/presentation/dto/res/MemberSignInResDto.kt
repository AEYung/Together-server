package com.aeyoung.together.domain.member.presentation.dto.res

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.ZonedDateTime

class MemberSignInResDto(

        val accessToken: String,
        val refreshToken: String,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
        val expiredAt: ZonedDateTime
) {
}
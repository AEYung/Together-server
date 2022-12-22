package com.aeyoung.together.domain.member.presentation.dto.req

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

class MemberSignInReqDto(

        @field:Email
        @field:NotBlank
        @field:Pattern(regexp = "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+\$")
        val email: String,
        @field:Size(min = 8, max = 20, message = "비밀번호는 최소 8자, 최대 20자여야 합니다.")
        @field:Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@\$!%*?&])[A-Za-z\\d@\$!%*?&]{8,20}\$")
        @field:NotBlank
        val password: String
) {
}
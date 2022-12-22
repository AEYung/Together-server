package com.aeyoung.together.domain.member.presentation.dto.req

import com.aeyoung.together.domain.member.Member
import com.aeyoung.together.domain.member.Role
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import java.util.Collections

class MemberSignUpReqDto(
        @field:Email
        @field:NotBlank
        @field:Pattern(regexp = "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+\$")
        val email: String,
        @field:NotBlank
        val name: String,
        @field:Size(min = 8, max = 20, message = "비밀번호는 최소 8자, 최대 20자여야 합니다.")
        @field:Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@\$!%*?&])[A-Za-z\\d@\$!%*?&]{8,}\$", message = "비밀번호는 대소문자,숫자,특수문자로 이루어져야합니다.")
        @field:NotBlank
        val password: String
) {

    fun toEntity(password: String): Member =
            Member(
                    email = email,
                    password = password,
                    name = name,
                    roles = Collections.singletonList(Role.ROLE_MEMBER)
            )
}
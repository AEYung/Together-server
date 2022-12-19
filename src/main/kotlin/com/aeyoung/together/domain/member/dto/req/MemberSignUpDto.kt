package com.aeyoung.together.domain.member.dto.req

import com.aeyoung.together.domain.member.Member
import com.aeyoung.together.domain.member.Role
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import java.util.Collections

class MemberSignUpDto(
        @field:Email
        val password: String,
        val email: String,
        @field:Size(min = 8)
        val name: String,
) {
    fun toEntity(passWord: String): Member =
            Member(email = email,
                    password = password,
                    name = name,
                    roles = Collections.singletonList(Role.ROLE_MEMBER)
            )
}
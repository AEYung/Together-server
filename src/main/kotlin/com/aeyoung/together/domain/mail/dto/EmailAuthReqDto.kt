package com.aeyoung.together.domain.mail.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern

class EmailAuthReqDto(
        @field:Email
        @field:NotBlank
        @field:Pattern(regexp = "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+\$")
        val email: String,
) {
}
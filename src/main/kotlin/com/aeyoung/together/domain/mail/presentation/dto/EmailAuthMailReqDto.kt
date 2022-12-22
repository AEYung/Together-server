package com.aeyoung.together.domain.mail.presentation.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

class EmailAuthMailReqDto (
        @field:Email
        @field:NotBlank
        @field:Pattern(regexp = "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+\$")
        val email: String,
        @field:NotBlank
        @field:Size(min = 6, max = 6, message = "인증 코드는 6자입니다.")
        val authCode:Int,
        @field:NotBlank
        val isCheckedEmail:Boolean
        ){

}
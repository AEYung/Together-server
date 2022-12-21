package com.aeyoung.together.domain.mail.service

import org.springframework.stereotype.Service

@Service
interface EmailAuthVerifyingService {

    fun execute(
            email: String,
            authCode: Int
    )
}
package com.aeyoung.together.domain.mail.service.Impl

import com.aeyoung.together.domain.mail.repository.EmailAuthRepository
import com.aeyoung.together.domain.mail.service.EmailAuthVerifyingService
import com.aeyoung.together.global.exception.WrongAuthCodeException
import org.springframework.stereotype.Service

@Service
class EmailAuthVerifyingServiceImpl(
        val emailAuthRepository: EmailAuthRepository
) : EmailAuthVerifyingService {

    override fun execute(
            email: String,
            authCode: Int
    ) {
        val emailAuth = emailAuthRepository.findById(email)
        emailAuth.orElseThrow { WrongAuthCodeException() }.authCode != authCode
        return
    }
}
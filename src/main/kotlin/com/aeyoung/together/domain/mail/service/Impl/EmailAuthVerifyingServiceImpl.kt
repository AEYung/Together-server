package com.aeyoung.together.domain.mail.service.Impl

import com.aeyoung.together.domain.mail.EmailAuth
import com.aeyoung.together.domain.mail.repository.EmailAuthRepository
import com.aeyoung.together.domain.mail.service.EmailAuthVerifyingService
import com.aeyoung.together.domain.mail.presentation.exception.WrongAuthCodeException
import com.aeyoung.together.domain.mail.presentation.exception.WrongEmailException
import org.springframework.stereotype.Service

@Service
class EmailAuthVerifyingServiceImpl(
        val emailAuthRepository: EmailAuthRepository,
) : EmailAuthVerifyingService {

    override fun execute(
            email: String,
            authCode: Int
    ) {
        val emailAuth = emailAuthRepository.findById(email)
                .orElseThrow { throw WrongEmailException() }
        if (emailAuth.authCode != authCode) {
            throw WrongAuthCodeException()
        }
        emailAuthRepository.save(EmailAuth(
                email = email,
                authCode = authCode,
                isChecked = true
        ))
        return
    }
}
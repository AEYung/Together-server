package com.aeyoung.together.domain.mail.service.Impl

import com.aeyoung.together.domain.mail.repository.EmailAuthRepository
import com.aeyoung.together.domain.mail.service.EmailAuthVerifyingService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class EmailAuthVerifyingServiceImpl(
        val emailAuthRepository: EmailAuthRepository
) : EmailAuthVerifyingService {

    override fun execute(
            email: String,
            authCode: Int
    ): Boolean {
        if (emailAuthRepository.existsById(email)) {
            if (emailAuthRepository.findById(email).orElseThrow().authCode == authCode) {
                return true
            }
        }
        return false
    }
}
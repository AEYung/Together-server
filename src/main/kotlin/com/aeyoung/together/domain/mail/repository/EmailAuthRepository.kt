package com.aeyoung.together.domain.mail.repository

import com.aeyoung.together.domain.mail.EmailAuth
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

interface EmailAuthRepository : CrudRepository<EmailAuth, String> {
    fun findAuthCodeById(email: String): Int
}
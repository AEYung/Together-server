package com.aeyoung.together.domain.mail.service

import org.springframework.stereotype.Service

@Service
interface EmailAuthSendingService {
    fun makeVerifyNum()

    fun joinEmail(email:String)

    fun sendMail(
            sendFrom:String,
            toMail:String,
            title:String,
            content:String
            )
}
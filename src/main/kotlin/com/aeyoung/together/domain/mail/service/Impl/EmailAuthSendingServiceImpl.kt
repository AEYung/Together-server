package com.aeyoung.together.domain.mail.service.Impl

import com.aeyoung.together.domain.mail.EmailAuth
import com.aeyoung.together.domain.mail.repository.EmailAuthRepository
import com.aeyoung.together.domain.mail.service.EmailAuthSendingService
import jakarta.mail.MessagingException
import jakarta.validation.constraints.Email
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.JavaMailSenderImpl
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service
import java.io.UnsupportedEncodingException
import java.util.*
import kotlin.collections.HashMap


@Service
class EmailAuthSendingServiceImpl(
        private val emailAuthRepository: EmailAuthRepository,
        private val mailSender: JavaMailSender
) : EmailAuthSendingService {

    private var verifyNum = 0;

    private val log = LoggerFactory.getLogger(this.javaClass.simpleName)

    override fun makeVerifyNum() {
        val r: Random = Random()
        verifyNum = r.nextInt(0, 888888)
        verifyNum += 111111
    }

    override fun joinEmail(email: String) {
        makeVerifyNum()
        val setFrom = "gsmtogether1@gmail.com"
        val title = "투게더 회원가입 인증 메일입니다."
        val content =
                "투게더를 이용해주셔서 감사합니니다." +
                        "<br><br>" +
                        "인증 번호는 " + verifyNum + "입니다." +
                        "<br>" +
                        "해당 인증번호를 인증번호 확인란에 기입해주세요."
        sendMail(setFrom, email, title, content)

        emailAuthRepository.save(EmailAuth(email = email, authCode = verifyNum, isChecked = false))
    }

    override fun sendMail(sendFrom: String, toMail: String, title: String, content: String) {
        val message = mailSender.createMimeMessage()

        try {
            val helper = MimeMessageHelper(message, true, "UTF-8")
            helper.setFrom(sendFrom)
            helper.setTo(toMail)
            helper.setSubject(title)
            helper.setText(content, true)
            mailSender.send(message)
        } catch (e: MessagingException) {
            e.printStackTrace();
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace();
        }
    }
}
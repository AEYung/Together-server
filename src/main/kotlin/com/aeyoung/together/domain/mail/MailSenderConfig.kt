import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.JavaMailSenderImpl
import java.util.*


@Configuration
class MailSenderConfig {
    @Value("\${spring.mail.host}")
    val host: String = ""

    @Value("\${spring.mail.port}")
    val port = 0

    @Value("\${spring.mail.username}")
    val username: String = ""

    @Value("\${spring.mail.password}")
    val password: String = ""

    @Value("\${spring.mail.default-encoding}")
    val defaultEncoding: String = ""

    @Value("\${spring.mail.properties}")
    val javaMailProperties: Properties = Properties()

    @Bean
    fun mailSender(): JavaMailSender {
        val properties = Properties()
        properties["mail.smtp.auth"] = true
        properties["mail.transport.protocol"] = "smtp"
        properties["mail.smtp.starttls.enable"] = true
        properties["mail.smtp.starttls.required"] = true
        properties["mail.debug"] = true

        val mailSender = JavaMailSenderImpl()
        mailSender.host = host
        mailSender.port = port
        mailSender.username = username
        mailSender.password = password
        mailSender.defaultEncoding = defaultEncoding
        mailSender.javaMailProperties = javaMailProperties

        return mailSender
    }
}
package com.aeyoung.together.global.config.socket

import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration


@Configuration
@EnableWebSocketMessageBroker
class WebSocketConfig : WebSocketMessageBrokerConfigurer {
    override fun configureWebSocketTransport(registry: WebSocketTransportRegistration) {
        // stomp 최대 버퍼 사이즈를 늘리기 위한 설정
        registry.setMessageSizeLimit(50000 * 1024)
        registry.setSendBufferSizeLimit(10240 * 1024)
        registry.setSendTimeLimit(20000)
    }

    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
        registry.addEndpoint("/socket").setAllowedOrigins("*").withSockJS()
    }

    override fun configureMessageBroker(registry: MessageBrokerRegistry) {
        registry.setApplicationDestinationPrefixes("/pub") //app
        registry.enableSimpleBroker("/sub") //topic
    }
}
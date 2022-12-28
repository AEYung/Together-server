package com.aeyoung.together.domain.videoCall.presentation

import com.aeyoung.together.domain.videoCall.presentation.dto.SocketSession
import org.json.simple.JSONObject
import org.springframework.context.event.EventListener
import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.socket.messaging.SessionDisconnectEvent

@RestController
class VideoRoomController(
    private val sessionIdList: MutableList<SocketSession>,
    private val template: SimpMessagingTemplate,
){
    @MessageMapping("/video/joined-room-info")
    @SendTo("/sub/video/joined-room-info")
    fun joinRoom(@Header("simpleSessionId") sessionId: String, ob: JSONObject): List<SocketSession>{
        sessionIdList.add(SocketSession(ob["from"].toString(), sessionId))
        return sessionIdList
    }

    @EventListener
    fun sessionDisconnectHandling(event: SessionDisconnectEvent){
        sessionIdList.forEach {
            if (it.sessionId == event.sessionId){
                sessionIdList.remove(it)
                template.convertAndSend("/sub/video/close-session", event.sessionId)
            }
        }
    }

    @MessageMapping("/video/caller-info")
    @SendTo("/sub/video/caller-info")
    fun caller(ob: JSONObject): Map<String, Object> =
        ob as Map<String, Object>

    @MessageMapping("/video/callee-info")
    @SendTo("/sub/video/callee-info")
    private fun answerCall(ob: JSONObject): Map<String, Any> =
        ob as Map<String, Object>
}
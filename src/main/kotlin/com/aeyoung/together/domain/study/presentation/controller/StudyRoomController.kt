package com.aeyoung.together.domain.study.presentation.controller

import com.aeyoung.together.domain.study.StudyRoom
import com.aeyoung.together.domain.study.presentation.dto.req.CreateStudyRoomReqDto
import com.aeyoung.together.domain.study.service.CreateStudyRoomService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/studies")
class StudyRoomController(
    val createStudyRoomService: CreateStudyRoomService
) {

    @PostMapping
    fun createStudyRoom(@Valid @RequestBody createStudyRoomReqDto: CreateStudyRoomReqDto): ResponseEntity<StudyRoom> {
        createStudyRoomService.createStudyRoom(createStudyRoomReqDto)
        return ResponseEntity.ok().build()
    }
}
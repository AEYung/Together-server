package com.aeyoung.together.domain.studyRoom.presentation.controller

import com.aeyoung.together.domain.studyRoom.presentation.dto.req.UpdateStudyRoomReqDto
import com.aeyoung.together.domain.studyRoom.presentation.dto.req.WriteNoticeCommentReqDto
import com.aeyoung.together.domain.studyRoom.presentation.dto.req.WriteNoticeReqDto
import com.aeyoung.together.domain.studyRoom.presentation.dto.res.CheckHostMemberResDto
import com.aeyoung.together.domain.studyRoom.presentation.dto.res.HostRoomInfoResDto
import com.aeyoung.together.domain.studyRoom.presentation.dto.res.MemberRoomInfoResDto
import com.aeyoung.together.domain.studyRoom.service.*
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rooms")
class StudyRoomController(
    val writeNoticeService: WriteNoticeService,
    val writeNoticeCommentService: WriteNoticeCommentService,
    val updateStudyRoomService: UpdateStudyRoomService,
    val getHostStudyInfoService: GetHostStudyInfoService,
    val getMemberStudyInfoService: GetMemberStudyInfoService,
    val checkHostMemberService: CheckHostMemberService
) {
    @PostMapping("/{studyId}/notices")
    fun writeNotice(@Valid @RequestBody writeNoticeReqDto: WriteNoticeReqDto, @PathVariable studyId: Long): ResponseEntity<Void> {
        writeNoticeService.execute(writeNoticeReqDto, studyId)
        return ResponseEntity.ok().build()
    }

    @PostMapping("/{studyId}/{noticeId}/comments")
    fun writeNoticeComment(@Valid @RequestBody writeNoticeCommentReqDto: WriteNoticeCommentReqDto, @PathVariable noticeId: Long): ResponseEntity<Void> {
        writeNoticeCommentService.execute(writeNoticeCommentReqDto, noticeId)
        return ResponseEntity.ok().build()
    }

    @PutMapping("/update/{studyId}")
    fun updateStudyRoom(@Valid @RequestBody updateStudyRoomReqDto: UpdateStudyRoomReqDto, @PathVariable studyId: Long): ResponseEntity<Void> {
        updateStudyRoomService.execute(updateStudyRoomReqDto, studyId)
        return ResponseEntity.ok().build()
    }

    @GetMapping("/{studyId}/host")
    fun checkHostMember(@PathVariable studyId: Long): ResponseEntity<CheckHostMemberResDto> =
        ResponseEntity.ok(checkHostMemberService.execute(studyId))

    @GetMapping("/host/{studyId}")
    fun getHostStudyRoomInfo(@PathVariable studyId: Long): ResponseEntity<HostRoomInfoResDto> =
        ResponseEntity.ok(getHostStudyInfoService.execute(studyId))


    @GetMapping("/member/{studyId}")
    fun getMemberStudyRoomInfo(@PathVariable studyId: Long): ResponseEntity<MemberRoomInfoResDto> =
        ResponseEntity.ok(getMemberStudyInfoService.execute(studyId))
}
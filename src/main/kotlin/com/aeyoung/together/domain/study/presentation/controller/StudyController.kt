package com.aeyoung.together.domain.study.presentation.controller

import com.aeyoung.together.domain.study.presentation.dto.req.ApplyPermissionStudyReqDto
import com.aeyoung.together.domain.study.presentation.dto.req.CreateStudyRoomReqDto

import com.aeyoung.together.domain.study.presentation.dto.res.PendingListResDto

import com.aeyoung.together.domain.study.presentation.dto.res.StudyListResDto
import com.aeyoung.together.domain.study.presentation.dto.res.StudyResDto
import com.aeyoung.together.domain.study.service.*
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/studies")
class StudyController(
    private val createStudyRoomService: CreateStudyRoomService,
    private val getAllStudyService: GetAllStudyService,
    private val getOneStudyService: GetOneStudyService,
    private val searchStudyService: SearchStudyService,
    private val applyStudyService: ApplyStudyService,
    private val getPendingListService: GetPendingListService,
    private val approveStudyMemberService: ApproveStudyMemberService,
) {

    @PostMapping
    fun createStudyRoom(@Valid @RequestBody createStudyRoomReqDto: CreateStudyRoomReqDto): ResponseEntity<Void> {
        createStudyRoomService.createStudyRoom(createStudyRoomReqDto)
        return ResponseEntity.ok().build()
    }

    @GetMapping
    fun getAllStudy(): ResponseEntity<StudyListResDto> =
        ResponseEntity.ok(getAllStudyService.execute())

    @GetMapping("/{id}")
    fun getOneStudy(@PathVariable id: Long): ResponseEntity<StudyResDto> =
        ResponseEntity.ok(getOneStudyService.execute(id))

    @GetMapping("/filtering")
    fun searchStudy(@RequestParam searchArgument: String): ResponseEntity<StudyListResDto> =
        ResponseEntity.ok(searchStudyService.execute(searchArgument))


    @PostMapping("/{id}")
    fun applyStudy(@PathVariable id: Long): ResponseEntity<Void> {
        applyStudyService.execute(id)
        return ResponseEntity.ok().build()
    }

    @PostMapping("/permission/{id}")
    fun applyStudy(@PathVariable id: Long, @RequestBody applyStudyReqDto: ApplyPermissionStudyReqDto): ResponseEntity<Void> {
        applyStudyService.execute(id, applyStudyReqDto)
        return ResponseEntity.ok().build()
    }

    @PostMapping("/private/{id}")
    fun applyStudy(@PathVariable id: Long, @RequestParam code: String): ResponseEntity<Void> {
        applyStudyService.execute(id, code)
        return ResponseEntity.ok().build()
    }

    @GetMapping("/{id}/pending-list")
    fun getPendingList(@PathVariable id: Long): ResponseEntity<PendingListResDto> =
        ResponseEntity.ok(getPendingListService.execute(id))

    @PostMapping("/approve/{id}")
    fun approvePendingUser(@PathVariable id: String): ResponseEntity<Void> {
        approveStudyMemberService.execute(id)
        return ResponseEntity.ok().build()
    }
}
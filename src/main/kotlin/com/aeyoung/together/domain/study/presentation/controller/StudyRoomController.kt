package com.aeyoung.together.domain.study.presentation.controller

import com.aeyoung.together.domain.study.StudyRoom
import com.aeyoung.together.domain.study.presentation.dto.req.CreateStudyRoomReqDto
import com.aeyoung.together.domain.study.presentation.dto.res.StudyListResDto
import com.aeyoung.together.domain.study.presentation.dto.res.StudyResDto
import com.aeyoung.together.domain.study.service.CreateStudyRoomService
import com.aeyoung.together.domain.study.service.GetAllStudyService
import com.aeyoung.together.domain.study.service.GetOneStudyService
import com.aeyoung.together.domain.study.service.SearchStudyService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/studies")
class StudyRoomController(
    private val createStudyRoomService: CreateStudyRoomService,
    private val getAllStudyService: GetAllStudyService,
    private val getOneStudyService: GetOneStudyService,
    private val searchStudyService: SearchStudyService,
) {

    @PostMapping
    fun createStudyRoom(@Valid @RequestBody createStudyRoomReqDto: CreateStudyRoomReqDto): ResponseEntity<StudyRoom> {
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

}
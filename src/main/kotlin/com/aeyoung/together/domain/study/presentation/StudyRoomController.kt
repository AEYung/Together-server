package com.aeyoung.together.domain.study.presentation

import com.aeyoung.together.domain.study.presentation.dto.res.StudyListResDto
import com.aeyoung.together.domain.study.presentation.dto.res.StudyResDto
import com.aeyoung.together.domain.study.service.GetAllStudyService
import com.aeyoung.together.domain.study.service.GetOneStudyService
import com.aeyoung.together.domain.study.service.SearchStudyService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/studies")
class StudyRoomController(
    private val getAllStudyService: GetAllStudyService,
    private val getOneStudyService: GetOneStudyService,
    private val searchStudyService: SearchStudyService,
){
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
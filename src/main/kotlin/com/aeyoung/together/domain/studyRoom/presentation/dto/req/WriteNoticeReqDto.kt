package com.aeyoung.together.domain.studyRoom.presentation.dto.req

import com.aeyoung.together.domain.member.Member
//import com.aeyoung.together.domain.study.Comment
import com.aeyoung.together.domain.studyRoom.StudyNotice
import com.aeyoung.together.domain.study.StudyRoom
import jakarta.validation.constraints.NotBlank

class WriteNoticeReqDto(
    @NotBlank
    val content: String,
) {
    fun toEntity(writer: Member, studyRoom: StudyRoom): StudyNotice =
        StudyNotice(
            writer = writer,
            content = content,
            studyRoom = studyRoom
        )
}
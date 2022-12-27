package com.aeyoung.together.domain.studyRoom.presentation.dto.req

import com.aeyoung.together.domain.member.Member
import com.aeyoung.together.domain.study.StudyRoom
import com.aeyoung.together.domain.study.StudyTag
import com.aeyoung.together.domain.study.enums.StudyRoomScope
import com.aeyoung.together.domain.studyRoom.StudyNotice
import com.aeyoung.together.global.entity.BaseIdEntity
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

class UpdateStudyRoomReqDto(
    @NotBlank
    val title: String,
    val description: String?,
    @NotBlank
    @Size(min = 1)
    val maximum: Int,
    @NotBlank
    val scope: StudyRoomScope,
    val question: String?,
    val code: String?,
    val tags: List<String>
) : BaseIdEntity() {
    fun toEntity(member: Member, tags: MutableList<StudyTag>): StudyRoom =
        StudyRoom(
            title = title,
            description = description,
            maximum = maximum,
            scope = scope,
            code = null,
            question = question,
            host = member,
            tags = tags
        )

    fun toEntity(member: Member, tags: MutableList<StudyTag>, code: String): StudyRoom =
        StudyRoom(
            title = title,
            description = description,
            maximum = maximum,
            scope = scope,
            code = code,
            question = question,
            host = member,
            tags = tags
        )

}
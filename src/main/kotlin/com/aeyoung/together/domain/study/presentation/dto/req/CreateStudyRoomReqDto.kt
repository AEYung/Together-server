package com.aeyoung.together.domain.study.presentation.dto.req

import com.aeyoung.together.domain.member.Member
import com.aeyoung.together.domain.study.StudyRoom
import com.aeyoung.together.domain.study.StudyTag
import com.aeyoung.together.domain.study.enums.StudyRoomScope
import jakarta.persistence.Enumerated
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import kotlin.math.min

class CreateStudyRoomReqDto(
    @NotBlank
    val title: String,
    val description: String?,
    @NotBlank
    @Size(min = 1)
    val maximum: Int,
    @NotBlank
    val scope: StudyRoomScope,
    val question: String?,
    val tags: List<String>?
) {
    fun toEntity(member: Member,tags:List<StudyTag>): StudyRoom =
        StudyRoom(
            title = title,
            description = description,
            maximum = maximum,
            scope = scope,
            question = question,
            host = member,
            tags = tags
        )
}
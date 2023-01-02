package com.aeyoung.together.domain.study.presentation.dto.res

import com.aeyoung.together.domain.study.StudyRoom
import com.aeyoung.together.domain.study.StudyTag

open class StudyResDto(
    val id: Long,
    val title: String,
    val description: String?,
    val maximum: Int,
    val currentCount: Int,
    val hostName: String,
    val tags: List<StudyTag>
){
    constructor(
        studyRoom: StudyRoom
    ):this(
        id = studyRoom.id,
        title = studyRoom.title,
        description = studyRoom.description,
        maximum = studyRoom.maximum,
        currentCount = studyRoom.members.size,
        hostName = studyRoom.host.name,
        tags = studyRoom.tags
    )
}
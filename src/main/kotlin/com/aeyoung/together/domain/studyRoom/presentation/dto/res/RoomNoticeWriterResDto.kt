package com.aeyoung.together.domain.studyRoom.presentation.dto.res

import com.aeyoung.together.domain.member.Member
import com.aeyoung.together.domain.studyRoom.StudyNotice

class RoomNoticeWriterResDto(
    val id: Long,
    val name: String
) {
    constructor(
        member: Member
    ) : this(
        id = member.id,
        name = member.name
    )
}
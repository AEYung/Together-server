package com.aeyoung.together.domain.studyRoom.presentation.dto.res

import com.aeyoung.together.domain.member.Member
import com.aeyoung.together.domain.study.StudyRoom
import com.aeyoung.together.domain.studyRoom.StudyNotice
import com.aeyoung.together.domain.studyRoom.StudyNoticeComment

class RoomNoticeResDto(
    val id: Long,
    val writer: RoomNoticeWriterResDto,
    val content: String,
    val comments: RoomNoticeCommentsResDto
) {
    constructor(
        studyNotice: StudyNotice
    ) : this(
        id = studyNotice.id,
        writer = RoomNoticeWriterResDto(member = studyNotice.writer),
        content = studyNotice.content,
        comments = RoomNoticeCommentsResDto(list = studyNotice.comments.map { RoomNoticeCommentResDto(it) })
    )
}
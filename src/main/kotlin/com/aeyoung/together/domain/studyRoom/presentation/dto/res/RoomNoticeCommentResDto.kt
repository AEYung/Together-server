package com.aeyoung.together.domain.studyRoom.presentation.dto.res

import com.aeyoung.together.domain.studyRoom.StudyNotice
import com.aeyoung.together.domain.studyRoom.StudyNoticeComment

class RoomNoticeCommentResDto(
    val id: Long,
    val writer: RoomNoticeCommentWriterResDto,
    val content: String
) {
    constructor(
        studyNoticeComment: StudyNoticeComment
    ) : this(
        id = studyNoticeComment.id,
        writer = RoomNoticeCommentWriterResDto(member = studyNoticeComment.writer),
        content = studyNoticeComment.content
    )
}
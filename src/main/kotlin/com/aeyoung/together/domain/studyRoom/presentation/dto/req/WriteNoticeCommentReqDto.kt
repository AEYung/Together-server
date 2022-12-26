package com.aeyoung.together.domain.studyRoom.presentation.dto.req

import com.aeyoung.together.domain.member.Member
import com.aeyoung.together.domain.studyRoom.StudyNotice
import com.aeyoung.together.domain.studyRoom.StudyNoticeComment
import jakarta.validation.constraints.NotBlank

class WriteNoticeCommentReqDto(
    @NotBlank
    val content: String,
) {
    fun toEntity(studyNotice: StudyNotice, writer: Member): StudyNoticeComment =
        StudyNoticeComment(
            content = content,
            notice = studyNotice,
            writer = writer
        )
}
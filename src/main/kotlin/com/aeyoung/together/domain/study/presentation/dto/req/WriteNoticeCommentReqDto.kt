package com.aeyoung.together.domain.study.presentation.dto.req

import com.aeyoung.together.domain.member.Member
import com.aeyoung.together.domain.study.StudyNotice
import com.aeyoung.together.domain.study.StudyNoticeComment
import jakarta.validation.constraints.NotBlank

class WriteNoticeCommentReqDto(
    @NotBlank
    val content: String,
    @NotBlank
    val noticeId: Long
) {
    fun toEntity(studyNotice: StudyNotice, writer: Member): StudyNoticeComment =
        StudyNoticeComment(
            content = content,
            notice = studyNotice,
            writer = writer
        )
}
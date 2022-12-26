package com.aeyoung.together.domain.study

import com.aeyoung.together.domain.member.Member
import com.aeyoung.together.global.entity.BaseIdEntity
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class StudyNoticeComment(
    val content: String,
    @ManyToOne
    @JoinColumn(name = "studyRoom_id")
    val notice: StudyNotice,
    @ManyToOne
    val writer:Member
) : BaseIdEntity() {
}
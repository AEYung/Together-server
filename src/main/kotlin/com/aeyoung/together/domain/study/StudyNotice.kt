package com.aeyoung.together.domain.study

import com.aeyoung.together.domain.member.Member
import com.aeyoung.together.global.entity.BaseIdEntity
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany

@Entity
class StudyNotice(
    @ManyToOne
    val writer: Member,
    val content: String,
    @ManyToOne
    @JoinColumn(name = "studyRoomId")
    val studyRoom: StudyRoom
) : BaseIdEntity() {
}
package com.aeyoung.together.domain.study

import com.aeyoung.together.domain.member.Member
import com.aeyoung.together.domain.study.enums.StudyRoomScope
import com.aeyoung.together.domain.studyRoom.StudyNotice
import com.aeyoung.together.global.entity.BaseIdEntity
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany

@Entity
class StudyRoom(
    val title: String,
    val description: String?,
    val maximum: Int,
    @Enumerated(EnumType.STRING)
    val scope: StudyRoomScope,
    val question: String?,
    val code: String?,
    @ManyToOne
    @JoinColumn(name = "host")
    val host: Member,
    @ManyToMany
    val tags: MutableList<StudyTag>

) : BaseIdEntity() {

    @ManyToMany
    val members: MutableList<Member> = mutableListOf()

    @OneToMany(mappedBy = "studyRoom")
    val studyNotices: MutableList<StudyNotice> = mutableListOf()
}
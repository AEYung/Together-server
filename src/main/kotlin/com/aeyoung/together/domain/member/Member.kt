package com.aeyoung.together.domain.member

import com.aeyoung.together.domain.study.StudyRoom
import com.aeyoung.together.global.entity.BaseIdEntity
import jakarta.persistence.*

@Entity
class Member(
    val email: String,
    val password: String,
    val name: String,

    @Enumerated(EnumType.STRING) @Column(name = "Role")
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Role", joinColumns = [JoinColumn(name = "member_id")])
    val roles: MutableList<Role>,
): BaseIdEntity(){
    @ManyToMany(mappedBy = "members")
    val studyList: MutableList<StudyRoom> = mutableListOf()

    @OneToMany(cascade = [CascadeType.REMOVE], mappedBy = "host")
    val hostStudy: MutableList<StudyRoom> = mutableListOf()
}
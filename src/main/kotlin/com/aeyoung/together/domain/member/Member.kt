package com.aeyoung.together.domain.member

import com.aeyoung.together.global.entity.BaseIdEntity
import jakarta.persistence.*

@Entity
class Member(
    val email: String,

    @Enumerated(EnumType.STRING) @Column(name = "Role")
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Role", joinColumns = [JoinColumn(name = "member_id")])
    val roles: MutableList<Role>,
): BaseIdEntity(){
}
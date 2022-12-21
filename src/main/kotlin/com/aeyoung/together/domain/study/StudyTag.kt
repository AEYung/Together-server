package com.aeyoung.together.domain.study

import com.aeyoung.together.global.entity.BaseIdEntity
import jakarta.persistence.Entity

@Entity
class StudyTag(
    val content: String,
): BaseIdEntity()
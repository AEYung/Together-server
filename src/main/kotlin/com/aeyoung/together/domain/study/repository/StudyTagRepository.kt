package com.aeyoung.together.domain.study.repository

import com.aeyoung.together.domain.study.StudyTag
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudyTagRepository : JpaRepository<StudyTag, Long> {
    fun findByContent(content:String):StudyTag?
}
package com.aeyoung.together.domain.study.repository

import com.aeyoung.together.domain.study.StudyRoom
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudyRoomRepository: JpaRepository<StudyRoom, Long> {
    fun findAllByDescriptionContains(description: String)
}
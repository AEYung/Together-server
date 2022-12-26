package com.aeyoung.together.domain.studyRoom.repository

import com.aeyoung.together.domain.studyRoom.StudyNotice
import org.springframework.data.jpa.repository.JpaRepository

interface StudyNoticeRepository : JpaRepository<StudyNotice, Long> {
}
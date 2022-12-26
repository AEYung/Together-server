package com.aeyoung.together.domain.study.repository

import com.aeyoung.together.domain.study.StudyNotice
import com.aeyoung.together.domain.study.StudyRoom
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface StudyNoticeRepository : JpaRepository<StudyNotice, Long> {
}
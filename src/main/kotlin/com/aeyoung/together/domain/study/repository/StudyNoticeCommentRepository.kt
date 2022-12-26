package com.aeyoung.together.domain.study.repository

import com.aeyoung.together.domain.study.StudyNoticeComment
import org.springframework.data.jpa.repository.JpaRepository

interface StudyNoticeCommentRepository : JpaRepository<StudyNoticeComment, Long> {
}
package com.aeyoung.together.domain.studyRoom.repository

import com.aeyoung.together.domain.studyRoom.StudyNoticeComment
import org.springframework.data.jpa.repository.JpaRepository

interface StudyNoticeCommentRepository : JpaRepository<StudyNoticeComment, Long> {
}
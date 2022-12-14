package com.aeyoung.together.domain.studyRoom.exception

import com.aeyoung.together.global.exception.BasicException
import com.aeyoung.together.global.exception.ErrorCode

class StudyNoticeNotFoundException : BasicException(ErrorCode.STUDY_NOTICE_NOT_FOUND) {
}
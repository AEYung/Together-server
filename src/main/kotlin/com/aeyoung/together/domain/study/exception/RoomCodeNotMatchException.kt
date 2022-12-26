package com.aeyoung.together.domain.study.exception

import com.aeyoung.together.global.exception.BasicException
import com.aeyoung.together.global.exception.ErrorCode

class RoomCodeNotMatchException(): BasicException(ErrorCode.STUDY_CODE_NOT_MATCH)
package com.aeyoung.together.domain.study.exception

import com.aeyoung.together.global.exception.BasicException
import com.aeyoung.together.global.exception.ErrorCode

class RoomScopeNotValidException: BasicException(ErrorCode.STUDY_SCOPE_NOT_VALID)
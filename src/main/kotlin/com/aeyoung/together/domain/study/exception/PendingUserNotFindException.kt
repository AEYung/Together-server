package com.aeyoung.together.domain.study.exception

import com.aeyoung.together.global.exception.BasicException
import com.aeyoung.together.global.exception.ErrorCode

class PendingUserNotFindException: BasicException(ErrorCode.MEMBER_NOT_FOUND) {
}
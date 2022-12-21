package com.aeyoung.together.domain.mail.exception

import com.aeyoung.together.global.exception.BasicException
import com.aeyoung.together.global.exception.ErrorCode

class NotCheckedEmailException: BasicException(ErrorCode.NOT_CHECKED_EMAIL) {
}
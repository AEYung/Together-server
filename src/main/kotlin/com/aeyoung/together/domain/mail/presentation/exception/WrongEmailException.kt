package com.aeyoung.together.domain.mail.presentation.exception

import com.aeyoung.together.global.exception.BasicException
import com.aeyoung.together.global.exception.ErrorCode

class WrongEmailException: BasicException(ErrorCode.WRONG_EMAIL) {
}
package com.aeyoung.together.domain.mail.exception

import com.aeyoung.together.global.exception.BasicException
import com.aeyoung.together.global.exception.ErrorCode

class WrongAuthCodeException() : BasicException(ErrorCode.WRONG_AUTHCODE) {
}
package com.aeyoung.together.domain.member.exception

import com.aeyoung.together.global.exception.BasicException
import com.aeyoung.together.global.exception.ErrorCode

class RefreshTokenNotValidException: BasicException(ErrorCode.TOKEN_NOT_VALID)
package com.aeyoung.together.global.security.jwt.exception

import com.aeyoung.together.global.exception.BasicException
import com.aeyoung.together.global.exception.ErrorCode

class TokenExpiredException: BasicException(ErrorCode.TOKEN_EXPIRED)
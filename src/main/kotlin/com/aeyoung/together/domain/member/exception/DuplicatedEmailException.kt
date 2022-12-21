package com.aeyoung.together.domain.member.exception

import com.aeyoung.together.global.exception.ErrorCode

open class DuplicatedEmailException(val errorCode: ErrorCode) : RuntimeException(errorCode.msg)
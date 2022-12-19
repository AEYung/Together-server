package com.aeyoung.together.global.exception

open class BasicException(val errorCode: ErrorCode) : RuntimeException(errorCode.msg)
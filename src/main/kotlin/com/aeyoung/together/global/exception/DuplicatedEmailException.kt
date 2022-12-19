package com.aeyoung.together.global.exception

open class DuplicatedEmailException(val errorCode: ErrorCode) : RuntimeException(errorCode.msg) {
}
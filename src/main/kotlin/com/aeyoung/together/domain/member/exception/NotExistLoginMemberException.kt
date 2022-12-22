package com.aeyoung.together.domain.member.exception

import com.aeyoung.together.global.exception.BasicException
import com.aeyoung.together.global.exception.ErrorCode

class NotExistLoginMemberException:BasicException(ErrorCode.NOT_EXIST_LOGIN_MEMBER) {
}
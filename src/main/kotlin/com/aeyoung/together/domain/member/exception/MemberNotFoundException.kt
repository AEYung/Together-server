package com.aeyoung.together.domain.member.exception

import com.aeyoung.together.global.exception.BasicException
import com.aeyoung.together.global.exception.ErrorCode

class MemberNotFoundException : BasicException(ErrorCode.MEMBER_NOT_FOUND)

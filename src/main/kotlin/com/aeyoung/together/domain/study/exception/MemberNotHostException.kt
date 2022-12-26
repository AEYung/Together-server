package com.aeyoung.together.domain.study.exception

import com.aeyoung.together.global.exception.BasicException
import com.aeyoung.together.global.exception.ErrorCode

class MemberNotHostException: BasicException(ErrorCode.NOT_HOST)
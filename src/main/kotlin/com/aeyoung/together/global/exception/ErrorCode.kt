package com.aeyoung.together.global.exception

enum class ErrorCode(
        val msg: String,
        val code: Int
) {
    BAD_REQUEST("잘못된 요청", 400),

    WRONG_AUTHCODE("잘못된 인증 코드입니다.", 400),

    WRONG_EMAIL("인증요청 하지 않은 이메일입니다.", 401),

    NOT_CHECKED_EMAIL("인증되지 않은 이메일입니다.", 401),

    UNAUTHORIZED("권한이 없음", 401),

    NOT_FOUND("리소스를 찾을수 없음", 404),

    DUPLICATE_EMAIL("중복되는 이메일입니다.", 409),

    INTERNAL_SERVER_ERROR("서버 내부 에러", 500)
}
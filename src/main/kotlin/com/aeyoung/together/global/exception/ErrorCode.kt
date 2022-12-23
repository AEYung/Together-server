package com.aeyoung.together.global.exception

enum class ErrorCode(
        val msg: String,
        val code: Int
) {
    BAD_REQUEST("잘못된 요청", 400),
    WRONG_AUTHCODE("잘못된 인증 코드입니다.", 400),
    WRONG_EMAIL("인증요청 하지 않은 이메일입니다.", 400),
    WRONG_PASSWORD("비밀번호가 올바르지 않습니다.", 400),

    NOT_EXIST_LOGIN_MEMBER("로그인 상태가 아닙니다.", 401),
    NOT_CHECKED_EMAIL("인증되지 않은 이메일입니다.", 401),
    TOKEN_EXPIRED("토큰이 만료되었습니다", 401),
    TOKEN_NOT_VALID("토큰이 유효하지 않습니다.", 401),
    UNAUTHORIZED("권한이 없음", 401),

    NOT_FOUND("리소스를 찾을수 없음", 404),
    MEMBER_NOT_FOUND("유저를 찾을 수 없습니다.", 404),
    STUDY_NOT_FOUND("해당 스터디를 찾을 수 없습니다.", 404),

    DUPLICATE_EMAIL("중복되는 이메일입니다.", 409),

    INTERNAL_SERVER_ERROR("서버 내부 에러", 500)
}
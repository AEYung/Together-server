package com.aeyoung.together.domain.studyRoom.presentation.dto.res

import com.aeyoung.together.domain.member.Member
import com.aeyoung.together.domain.study.StudyRoom

class GetRoomInfoResDto(
    val title: String,
    val code: String?,
    val notices: RoomNoticesResDto,
    val members: RoomMembersResDto,
) {
    constructor(
        studyRoom: StudyRoom
    ) : this(

        title = studyRoom.title,
        code = studyRoom.code,
        notices = RoomNoticesResDto(
            list = studyRoom.studyNotices.map { RoomNoticeResDto(it) }
        ),
        members = RoomMembersResDto(
            list = studyRoom.members.map { RoomMemberResDto(it) }
        )
    )
}
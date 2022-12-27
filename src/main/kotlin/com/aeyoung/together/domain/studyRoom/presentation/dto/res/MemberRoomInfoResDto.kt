package com.aeyoung.together.domain.studyRoom.presentation.dto.res

import com.aeyoung.together.domain.study.StudyRoom

class MemberRoomInfoResDto(
    val title: String,
    val notices: RoomNoticesResDto,
    val members: RoomMembersResDto,
) {
    constructor(
        studyRoom: StudyRoom
    ) : this(

        title = studyRoom.title,
        notices = RoomNoticesResDto(
            list = studyRoom.studyNotices.map { RoomNoticeResDto(it) }
        ),
        members = RoomMembersResDto(
            list = studyRoom.members.map { RoomMemberResDto(it) }
        )
    )
}
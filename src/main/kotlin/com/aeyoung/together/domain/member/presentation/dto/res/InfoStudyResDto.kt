package com.aeyoung.together.domain.member.presentation.dto.res

import com.aeyoung.together.domain.member.Member
import com.aeyoung.together.domain.study.StudyRoom
import com.aeyoung.together.domain.study.presentation.dto.res.StudyResDto

class InfoStudyResDto(
    studyRoom: StudyRoom,
): StudyResDto(studyRoom) {
    constructor(studyRoom: StudyRoom, member: Member):this(studyRoom){
        member.hostStudy.contains(studyRoom)
        isHost = true
    }
    var isHost: Boolean = false
}
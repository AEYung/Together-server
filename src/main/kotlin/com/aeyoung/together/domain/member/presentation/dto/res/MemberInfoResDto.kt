package com.aeyoung.together.domain.member.presentation.dto.res

import com.aeyoung.together.domain.study.presentation.dto.res.StudyResDto

class MemberInfoResDto(
    val id : Long,
    val studyList: List<InfoStudyResDto>,
    val pendingStudyList: List<InfoStudyResDto>,
)
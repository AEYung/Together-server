package com.aeyoung.together.domain.study.repository

import com.aeyoung.together.domain.study.PendingUser
import org.springframework.data.repository.CrudRepository

interface PendingUserRepository : CrudRepository<PendingUser, String>{
    fun findAllByStudyId(studyId: Long): List<PendingUser>
}
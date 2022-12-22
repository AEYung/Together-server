package com.aeyoung.together.domain.study.util

import com.aeyoung.together.domain.study.StudyTag
import org.springframework.stereotype.Component

@Component
class StudyTagUtil {
    fun isContainTag(tags: List<StudyTag>, content: String): Boolean{
        tags.forEach {
            if(it.content == content)
                return true
        }
        return false
    }
}
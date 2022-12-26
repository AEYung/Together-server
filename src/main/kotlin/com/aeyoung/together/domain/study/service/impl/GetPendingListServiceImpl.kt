package com.aeyoung.together.domain.study.service.impl

import com.aeyoung.together.domain.study.presentation.dto.res.PendingListResDto
import com.aeyoung.together.domain.study.presentation.dto.res.PendingResDto
import com.aeyoung.together.domain.study.repository.PendingUserRepository
import com.aeyoung.together.domain.study.service.GetPendingListService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true, rollbackFor = [Exception::class])
class GetPendingListServiceImpl(
    private val pendingUserRepository: PendingUserRepository,
): GetPendingListService {
    override fun execute(id: Long): PendingListResDto {
        return PendingListResDto(
            list = pendingUserRepository.findAll()
                    .filter { it.studyId == id }
                    .map { PendingResDto(it) }
        )
    }
}
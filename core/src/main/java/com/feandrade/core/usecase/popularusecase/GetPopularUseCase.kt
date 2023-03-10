package com.feandrade.core.usecase.popularusecase

import kotlinx.coroutines.flow.Flow
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.feandrade.core.model.PhotoDomain

interface GetPopularUseCase {
    operator fun invoke(params: GetPopularParams): Flow<PagingData<PhotoDomain>>
    data class GetPopularParams(val pagingConfig: PagingConfig)
}


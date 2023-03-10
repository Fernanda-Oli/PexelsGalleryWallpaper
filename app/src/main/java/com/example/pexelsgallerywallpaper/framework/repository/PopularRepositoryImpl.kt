package com.example.pexelsgallerywallpaper.framework.repository

import androidx.paging.PagingSource
import com.example.pexelsgallerywallpaper.framework.network.response.DataWrapperResponse
import com.example.pexelsgallerywallpaper.framework.paging.PopularPagingSource
import com.feandrade.core.data.PopularRepository
import com.feandrade.core.data.RemoteDataSource
import com.feandrade.core.model.PhotoDomain
import javax.inject.Inject

class PopularRepositoryImpl @Inject constructor(
   private val remoteDataSource: RemoteDataSource<DataWrapperResponse>
) : PopularRepository {
    override fun fetchPopular(page: Int): PagingSource<Int, PhotoDomain> {
        return PopularPagingSource(remoteDataSource, page)
    }
}
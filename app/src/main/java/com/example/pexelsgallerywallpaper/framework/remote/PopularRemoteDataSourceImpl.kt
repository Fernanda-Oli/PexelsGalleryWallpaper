package com.example.pexelsgallerywallpaper.framework.remote

import com.example.pexelsgallerywallpaper.framework.network.api.WallpapersApi
import com.example.pexelsgallerywallpaper.framework.network.response.DataWrapperResponse
import com.feandrade.core.data.RemoteDataSource
import javax.inject.Inject

class PopularRemoteDataSourceImpl @Inject constructor(
    private val api: WallpapersApi
) : RemoteDataSource<DataWrapperResponse> {
    override suspend fun fetchPopular(page: Int, perPage: Int): DataWrapperResponse =
        api.getPopularWallpapers(page, perPage)
}
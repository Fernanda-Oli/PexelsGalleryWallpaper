package com.example.pexelsgallerywallpaper.framework.di

import com.example.pexelsgallerywallpaper.framework.network.response.DataWrapperResponse
import com.example.pexelsgallerywallpaper.framework.remote.PopularRemoteDataSourceImpl
import com.example.pexelsgallerywallpaper.framework.repository.PopularRepositoryImpl
import com.feandrade.core.data.PopularRepository
import com.feandrade.core.data.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindPopularRepository(repositoryImpl: PopularRepositoryImpl): PopularRepository

    @Binds
    fun bindRemoteDataSourceRepository(dataSourceImpl: PopularRemoteDataSourceImpl) : RemoteDataSource<DataWrapperResponse>
}
package com.example.pexelsgallerywallpaper.framework.di

import android.content.Context
import androidx.room.Room
import com.example.pexelsgallerywallpaper.framework.db.GalleryWallpaperDB
import com.feandrade.core.data.DBConstants.APP_DATA_BASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    @Provides
    fun providesGalleryWallpaperDB(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, GalleryWallpaperDB::class.java, APP_DATA_BASE_NAME
    ).build()

    @Provides
    fun providesGalleryWallpaperDAO(db : GalleryWallpaperDB) = db.galleryWallpaperDAO()
}
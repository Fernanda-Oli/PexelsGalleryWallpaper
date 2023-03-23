package com.example.pexelsgallerywallpaper.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pexelsgallerywallpaper.framework.db.dao.GalleryWallpaperDAO
import com.example.pexelsgallerywallpaper.framework.db.entity.PhotoEntity

@Database(entities = [PhotoEntity::class], version = 1, exportSchema = false)
abstract class GalleryWallpaperDB : RoomDatabase() {
    abstract fun galleryWallpaperDAO(): GalleryWallpaperDAO
}
package com.example.pexelsgallerywallpaper.framework.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pexelsgallerywallpaper.framework.db.entity.PhotoEntity
import com.feandrade.core.data.DBConstants
import kotlinx.coroutines.flow.Flow


@Dao
interface GalleryWallpaperDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity : PhotoEntity)

    @Query("SELECT * FROM ${DBConstants.PHOTO_TABLE}")
    suspend fun getAllPhoto() : Flow<List<PhotoEntity>>

    @Query("DELETE FROM ${DBConstants.PHOTO_TABLE} WHERE id = :id")
    suspend fun deleteByID(id : Int)
}
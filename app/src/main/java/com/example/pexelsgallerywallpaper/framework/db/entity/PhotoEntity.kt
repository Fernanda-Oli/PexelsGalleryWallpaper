package com.example.pexelsgallerywallpaper.framework.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.feandrade.core.data.DBConstants.PHOTO_TABLE

@Entity(tableName = PHOTO_TABLE)
data class PhotoEntity(
    @PrimaryKey
    val id : Int,
    val photo : String
)
package com.example.pexelsgallerywallpaper.framework.downloader.androiddownloader

interface Downloader {
    fun downloadFile(url: String, description: String): Long
}
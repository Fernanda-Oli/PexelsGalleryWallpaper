package com.feandrade.core.data

import androidx.paging.PagingSource
import com.feandrade.core.model.PhotoDomain

interface PopularRepository {
   fun fetchPopular(pages : Int) : PagingSource<Int, PhotoDomain>
}
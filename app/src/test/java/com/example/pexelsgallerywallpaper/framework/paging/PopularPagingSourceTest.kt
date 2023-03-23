package com.example.pexelsgallerywallpaper.framework.paging

import androidx.paging.PagingSource
import com.example.pexelsgallerywallpaper.framework.network.response.DataWrapperResponse
import com.example.testing.MainCoroutinesRule
import com.example.pexelsgallerywallpaper.factory.DataWrapperResponseFactory
import com.example.testing.model.WallpapersFactory
import com.feandrade.core.data.RemoteDataSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class PopularPagingSourceTest {
    @get: Rule
    var mainCoroutinesRule = MainCoroutinesRule()

    @Mock
    var mockRemoteDataSource = mock<RemoteDataSource<DataWrapperResponse>>()
    private lateinit var popularPagingSource: PopularPagingSource
    private var dataWrapperResponseFactory = DataWrapperResponseFactory()
    private val wallpapersFactory =
        WallpapersFactory().create(WallpapersFactory.Photo.PhotDomainSuccess)

    @Before
    fun setup() {
        popularPagingSource = PopularPagingSource(mockRemoteDataSource, 40)
    }

    @Test
    fun `should validate paging data success when invoke from repository is called`() = runTest {
        whenever(mockRemoteDataSource.fetchPopular(any(), any()))
            .thenReturn(dataWrapperResponseFactory.create())
        val result = popularPagingSource.load(
            PagingSource.LoadParams.Refresh(
                null,
                loadSize = 40,
                placeholdersEnabled = false
            )
        )
        val expected = listOf(wallpapersFactory)
        assertEquals(
            PagingSource.LoadResult.Page(
                data = expected,
                prevKey = null,
                nextKey = 2
            ),
            result
        )
    }
}
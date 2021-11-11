package com.mindorks.example.paging3.data.datasource

import androidx.paging.PagingSource
import com.mindorks.example.paging3.data.APIService
import com.mindorks.example.paging3.data.response.Data
import java.io.IOException

class PostDataSource(private val apiService: APIService) : PagingSource<Int, Data>() {

    private val DEFAULT_PAGE_INDEX= 1

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        val currentLoadingPageKey = params.key ?: DEFAULT_PAGE_INDEX
        return try {
            val response = apiService.getListData(currentLoadingPageKey)
            val responseData = mutableListOf<Data>()
            val data = response.myData ?: emptyList()
            responseData.addAll(data)

            val prevKey = if (currentLoadingPageKey == DEFAULT_PAGE_INDEX) null else currentLoadingPageKey - 1
            val nextKey = if(responseData.isEmpty()) null else currentLoadingPageKey + 1

            return LoadResult.Page(
                data = responseData,
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        } catch (e: IOException) {
            LoadResult.Error(e)
        }
    }

}
package com.reeta.addressproject.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.reeta.addressproject.response.Address
import com.reeta.addressproject.response.Network

class AddressPagingSource :PagingSource<Int,Address>() {

    private val apiCall=Network.getApiService()
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Address> {
        val pageNumber=params.key ?:1
        val responseDTO=apiCall.getInstance(Network.queryString,Network.city,pageNumber)
        val addressList:List<Address> =responseDTO.data.addressList
        return try {
            LoadResult.Page(data = addressList,prevKey = null,nextKey = if (addressList.isEmpty()) null else pageNumber+1)
        }catch (e:Exception){
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Address>): Int? {
        return state.anchorPosition
    }
}
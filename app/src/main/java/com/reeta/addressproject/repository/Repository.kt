package com.reeta.addressproject.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.reeta.addressproject.paging.AddressPagingSource
import com.reeta.addressproject.response.Network
import com.reeta.addressproject.response.ResponseDTO

class Repository {



//    suspend fun getAddress():ResponseDTO{
//        return Network.getApiService().getInstance(queryString,city,1)
//    }

    fun getPageList()=Pager(config = PagingConfig(pageSize = 20),
    pagingSourceFactory = {AddressPagingSource()}).liveData
}
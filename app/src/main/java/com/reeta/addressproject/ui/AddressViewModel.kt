package com.reeta.addressproject.ui

import androidx.lifecycle.ViewModel
import com.reeta.addressproject.repository.Repository

class AddressViewModel():ViewModel() {

    private val respository=Repository()
    fun searchAddress()=respository.getPageList()

}
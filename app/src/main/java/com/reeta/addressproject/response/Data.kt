package com.reeta.addressproject.response

data class Data(
    val addressList: List<Address>,
    val autoCompleteRequestString: String,
    val focusWord: String,
    val totalFindByRSUHits: Int,
    val totalNoRSUReturned: Int
)
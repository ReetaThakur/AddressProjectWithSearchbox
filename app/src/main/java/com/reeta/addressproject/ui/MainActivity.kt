package com.reeta.addressproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.reeta.addressproject.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: AddressViewModel
    private lateinit var addressAdapter: AddressAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel=ViewModelProvider(this).get(AddressViewModel::class.java)
        setAdapter()
        viewModel.searchAddress().observe(this,{
            it?.let {
                CoroutineScope(Dispatchers.Main).launch {
                    addressAdapter.submitData(it)
                }
            }
        })
    }

    private fun setAdapter() {
        addressAdapter= AddressAdapter()
        val linearLayoutManager=LinearLayoutManager(this)
        recyclerView.apply {
            layoutManager=linearLayoutManager
            this.adapter=addressAdapter
        }

    }
}
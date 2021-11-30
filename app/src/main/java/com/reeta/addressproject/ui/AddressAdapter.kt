package com.reeta.addressproject.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.reeta.addressproject.R
import com.reeta.addressproject.response.Address

class AddressAdapter:PagingDataAdapter<Address,AddressAdapter.AddressViewHolder>(diffUtil) {

    companion object{
        val diffUtil =object :DiffUtil.ItemCallback<Address>(){
            override fun areItemsTheSame(oldItem: Address, newItem: Address): Boolean {
               return oldItem.id==newItem.id
            }

            override fun areContentsTheSame(oldItem: Address, newItem: Address): Boolean {
                return oldItem.equals(newItem)
            }

        }
    }

    override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {
       val address=getItem(position)
        address.let {
            if (it!=null){
                holder.setData(it)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
       val view:View=LayoutInflater.from(parent.context).inflate(R.layout.address_layout,parent,false)
        return AddressViewHolder(view)
    }

    class AddressViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val pata:TextView=itemView.findViewById(R.id.tvAddress)
        val sahar:TextView=itemView.findViewById(R.id.tvCity)
        val pin:TextView=itemView.findViewById(R.id.tvPinCode)
        fun setData(address:Address){
            pata.text=address.addressString
            sahar.text=address.city
            pin.text=address.pinCode
        }
    }

}
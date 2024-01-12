package com.example.newappmarcket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newappmarcket.databinding.ItemBinding
import java.text.DecimalFormat


class ItemAdapter(private val mItems: MutableList<Sell>) : RecyclerView.Adapter<ItemAdapter.Holder>() {

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }


    var itemClick: ItemClick? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)

    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }

        holder.sellImage.setImageResource(mItems[position].itemImage)
        holder.productName.text = mItems[position].itemName
        holder.productAd.text = mItems[position].itemAddress


        val price = mItems[position].price
        holder.productPrice.text = DecimalFormat("#,###").format(price) + "원"

        if (mItems[position].isLike)
            holder.ivAdapterLike.setImageResource(R.drawable.heart)
        else
            holder.ivAdapterLike.setImageResource(R.drawable.heart)

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    inner class Holder(binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val productName = binding.productName
        val productAd = binding.productAd
        val sellImage = binding.sellImage
        val productPrice = binding.productPrice
        val ivAdapterLike = binding.heart
        val heartCount = binding.heartCount
//        val chatCount = binding.chatCount
//        해결됨.
    }

}





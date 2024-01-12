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


//    companion object {
//        private const val VIEW_TYPE_Dates = 1
//        private const val VIEW_TYPE_Items = 2
//
//    }
//
//    interface ItemClick {
//        fun onClick(view: View, position: Int)
//    }
//
//    var itemClick: ItemClick? = null
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//
//        val inflater = LayoutInflater.from(parent.context)
//        return when (viewType) {
//            VIEW_TYPE_Dates -> {
//                val binding =
//                    ItemTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                TitleViewHolder(binding)
//            }
//
//            else -> {
//                val binding =
//                    ItemRecyclerviewBinding.inflate(
//                        LayoutInflater.from(parent.context),
//                        parent,
//                        false
//                    )
//                ItemViewHolder(binding)
//            }
//        }
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        when (val item = mItems[position]) {
//            is Sell.Date -> {
//                (holder as TitleViewHolder).title.text = "${item.uploadDate} 일전"
//            }
//
//            is Sell.Item -> {
//                (holder as ItemViewHolder).itemName.text = item.itemName
//                holder.price.text = item.price.toString()
//                holder.iconImageView.setImageResource(item.itemImage)
//                holder.itemAddress.text = item.itemAddress
//                holder.itemView.setOnClickListener {
//                    itemClick?.onClick(it, position)
//                }
//            }
//        }
//    }
//
//    override fun getItemId(position: Int): Long {
//        return position.toLong()
//    }
//
//    override fun getItemCount(): Int {
//        return mItems.size
//    }
//
//    override fun getItemViewType(position: Int): Int {
//        return when (mItems[position]) {
//            is Sell.Date -> VIEW_TYPE_Dates
//            is Sell.Item -> VIEW_TYPE_Items
//            else -> throw IllegalArgumentException("Invalid Sell type at position $position")
//        }
//    }
//
//    inner class TitleViewHolder(binding: ItemTitleBinding) : RecyclerView.ViewHolder(binding.root) {
//        val title = binding.tvAgetitle
//    }
//
//    inner class ItemViewHolder(binding: ItemRecyclerviewBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//        val iconImageView = binding.sellImage
//        val itemAddress = binding.productAd
//        val itemName = binding.productName
//        val price = binding.productPrice
//
//        init {
//            itemView.setOnClickListener {
//                itemClick?.onClick(it, adapterPosition)
//            }
//        }
//    }
//}
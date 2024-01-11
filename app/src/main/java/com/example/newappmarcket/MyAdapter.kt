package com.example.newapplemarcket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.newappmarcket.Sell
import com.example.newappmarcket.databinding.ItemRecyclerviewBinding
import com.example.newappmarcket.databinding.ItemTitleBinding

class MyAdapter(val mItems: MutableList<Any>) : RecyclerView.Adapter<ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_Date = 1
        private const val VIEW_TYPE_Item = 2

    }

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_TYPE_Date -> {
                val binding =
                    ItemTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                DateViewHolder(binding)
            }

            else -> {
                val binding =
                    ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ItemViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (val item = mItems[position]) {
            is Sell.Date -> {
                (holder as DateViewHolder).title.text = "${item.uploadDate}"
            }
            is Sell.Item -> {
                (holder as ItemViewHolder).itemName.text = item.itemName
                holder.itemName.text = item.itemName
                holder.price.text = item.price.toString()
                holder.itemAddress.text = item.itemAddress
                holder.iconImageView.setImageResource(item.itemImage)


                holder.itemView.setOnClickListener {
                    itemClick?.onClick(it, position)
                }
            }
        }
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (mItems[position]) {
            is Sell.Date -> {
                VIEW_TYPE_Date
            }
            is Sell.Item -> {
                VIEW_TYPE_Item
            }

            else -> { throw IllegalArgumentException("Unhandled view type at position $position")}
        }
    }

    inner class DateViewHolder(binding: ItemTitleBinding) : RecyclerView.ViewHolder(binding.root) {
        val title = binding.tvAgetitle
    }

    inner class ItemViewHolder(binding: ItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val iconImageView = binding.sellImage
        val itemAddress = binding.productAd
        val itemName = binding.productName
        val price = binding.productPrice
    }
}















//package com.example.newapplemarcket
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.newappmarcket.Sell
//import com.example.newappmarcket.databinding.ItemRecyclerviewBinding
//import com.example.newappmarcket.databinding.ItemTitleBinding
//
//
//class MyAdapter(private val mItems: MutableList<Any>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//
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
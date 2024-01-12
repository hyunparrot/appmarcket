package com.example.newappmarcket

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.example.newappmarcket.databinding.ActivityDetailBinding
import java.text.DecimalFormat

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    private var isLike = false

    private val item: Sell? by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(Constants.ITEM_OBJECT, Sell::class.java)
        } else {
            intent.getParcelableExtra<Sell>(Constants.ITEM_OBJECT)
        }
    }

    private val itemPosition: Int by lazy {
        intent.getIntExtra(Constants.ITEM_INDEX, 0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView.setImageDrawable(item?.let {
            ResourcesCompat.getDrawable(
                resources,
                it.itemImage,
                null
            )
        })

        binding.tvName.text = item?.sellerName
        binding.tvAddress.text = item?.itemAddress
        binding.tvItem.text = item?.itemName
        binding.tvItemDetail.text = item?.itemDetail
        binding.tvItemDetailPrice.text = DecimalFormat("#,###").format(item?.price) + "원"

        isLike = item?.isLike == true
    }
}

//    val sellItem = intent.getSerializableExtra("SELL_ITEM") as Sell
//    val imagePath = sellItem.image

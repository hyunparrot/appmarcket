package com.example.newappmarcket


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Sell(
    val itemImage: Int,
    val itemName: String,
    val itemAddress: String,
    val price: Int,
    val itemDetail: String,
    val sellerName: String,
    val chatCnt: Int,
    var interestCnt: Int,
    var isLike: Boolean
) : Parcelable


//    data class Date(var uploadDate: String)



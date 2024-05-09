package com.example.nbc6application.adapter

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nbc6application.data.Documents
import com.example.nbc6application.data.KakaoData
import com.example.nbc6application.databinding.ItemGridBinding

interface KakaoImageClickListener {
    fun onClickItem(kakaoData: Documents)
}

interface KakaoImageDataClickListener{
    fun onPassData(kakaoData: Documents)
}

class KakaoRecyclerViewAdapter(
    private val kakaoImageDataClickListener: KakaoImageDataClickListener
) : RecyclerView.Adapter<KakaoViewHoler>() {

    var kakoList: List<Documents> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KakaoViewHoler {
        val layoutInflater = LayoutInflater.from(parent.context)
        return KakaoViewHoler(
            binding = ItemGridBinding.inflate(layoutInflater, parent, false),
            object : KakaoImageClickListener{
                override fun onClickItem(kakaoData: Documents) {
                    notifyDataSetChanged()
                    kakaoImageDataClickListener.onPassData(kakaoData)
                }
            }
        )
    }

    override fun onBindViewHolder(holder: KakaoViewHoler, position: Int) {
        val kakaoItem = kakoList[position]
        holder.bind(kakaoItem = kakaoItem)
    }

    override fun getItemCount(): Int {
        return this.kakoList.size
    }

    fun submitList(item: List<Documents>) {
        this.kakoList = item
        notifyDataSetChanged()
    }
}


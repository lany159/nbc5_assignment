package com.example.nbc6application.adapter

import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nbc6application.data.Documents
import com.example.nbc6application.databinding.ItemGridBinding

class KakaoViewHoler(
    private val binding: ItemGridBinding,
    private val kakaoImageClickListener: KakaoImageClickListener
) :
    RecyclerView.ViewHolder(binding.root) {

    private var kakaoData: Documents? = null

    init {
        binding.root.setOnClickListener {
            kakaoData?.let {
                kakaoImageClickListener.onClickItem(kakaoData = it)
//                it.copy(
//                    isLike = !it.isLike
//                )
                  it.isLike = !it.isLike
            }
        }
    }

    fun bind(kakaoItem: Documents) {
        this.kakaoData = kakaoItem
        Glide.with(binding.root.context).load(kakaoItem.thumbnail_url).into(binding.ivProfile)

        binding.tvTitle.text = kakaoItem.display_sitename
        binding.tvDate.text = kakaoItem.datetime.toString()

        when(kakaoItem.isLike){
            true -> binding.ivLike.isVisible = true
            false -> binding.ivLike.isVisible = false
        }
    }
}
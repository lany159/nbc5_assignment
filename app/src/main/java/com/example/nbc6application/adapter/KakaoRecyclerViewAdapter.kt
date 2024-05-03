package com.example.nbc6application.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nbc6application.data.KakaoData
import com.example.nbc6application.databinding.ItemGridBinding

class KakaoRecyclerViewAdapter(val kakoList: List<KakaoData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ViewHoler(private val binding: ItemGridBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(kakaoData: KakaoData){
        //이미지 연결 binding.ivProfile
            //필요한 리스트 중에 필요한 것만 가져오는 것인지?
            //루트가 카카오데이터의 documents이긴 하나, documents의 데이터 클래스로 직접 가져와야 하는지?
            //> 그렇다면 val kakoList: List<KakaoData> 를 <Documents>로 수정
            binding.tvTitle.text = kakaoData.documents.toString()
            binding.tvDate.text = kakaoData.documents.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}
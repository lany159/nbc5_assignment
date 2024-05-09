package com.example.nbc6application

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.lifecycleScope
import com.example.nbc6application.adapter.KakaoImageDataClickListener
import com.example.nbc6application.adapter.KakaoRecyclerViewAdapter
import com.example.nbc6application.api.NetWorkClient
import com.example.nbc6application.data.Documents
import com.example.nbc6application.databinding.FragmentMainBinding
import kotlinx.coroutines.launch


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private var adapter: KakaoRecyclerViewAdapter =
        KakaoRecyclerViewAdapter(kakaoImageDataClickListener = object : KakaoImageDataClickListener {
            override fun onPassData(kakaoData: Documents) {
//                val result = "result"
//                setFragmentResult("requestKey", bundleOf("bundleKey" to result))
//                parentFragmentManager.beginTransaction()
//                    .replace(R.id.iv_like, DetailFragment())
//                    //.replace(R.id.viewPager, DetailFragment())
//                    .commit()
                //room > save
            }
        })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {//뷰 변경
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = this.adapter

        binding.btnSearchClick.setOnClickListener {
            if (binding.etSearchText.text.toString().isNotEmpty()) {
                communicateNetWork(binding.etSearchText.text.toString())
                hideKeyboard()
                requireActivity().currentFocus!!.clearFocus()
            } else {
                return@setOnClickListener
            }
        }
    }

    private fun communicateNetWork(query: String) = lifecycleScope.launch {

        try {
            val responseData = NetWorkClient.kakaoNetWork.getKakao(query, 80)
            Log.d("debug100", responseData.toString())
            adapter.submitList(responseData.documents) //데이터 갱신
        }catch (e: retrofit2.HttpException){

        }
    }

    private fun hideKeyboard(){
        val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(requireActivity().currentFocus?.windowToken, 0)
    }
}

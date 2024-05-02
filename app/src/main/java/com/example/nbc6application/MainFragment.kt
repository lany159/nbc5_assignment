package com.example.nbc6application

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import com.example.nbc6application.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayoutMediator


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)


        val viewPagerAdapter = ViewPagerAdapter(this)//프레그먼트에 할당 된 컨텍스트를 끌고옴
        binding.viewPager.adapter = viewPagerAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tap, position ->
            when (position) {
                0 -> {
                    tap.setIcon(R.drawable.tap1)
                    tap.text = "이미지 검색"
                }

                1 -> {
                    tap.setIcon(R.drawable.tap2)
                    tap.text = "내 보관함"
                }
            }
        }.attach()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {//뷰 변경
        super.onViewCreated(view, savedInstanceState)


    }


//    private fun initSeachView(){
//        binding.searchView.isSubmitButtonEnabled = true
//        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                return true
//            }
//        })
//    }
}

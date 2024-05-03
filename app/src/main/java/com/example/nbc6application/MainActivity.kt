package com.example.nbc6application

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.nbc6application.api.NetWorkClient
import com.example.nbc6application.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setFragment()
        communicateNetWork(" ")
    }

    private fun setFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(binding.frameLayout.id, MainFragment())
            .addToBackStack("")
            .commit()
    }

    private fun communicateNetWork(query:String) = lifecycleScope.launch{
        //TODO
        val responseData = NetWorkClient.kakaoNetWork.getKakao("cindy")
        Log.d("debug100",responseData.toString())

    }
}
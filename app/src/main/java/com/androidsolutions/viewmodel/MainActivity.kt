package com.androidsolutions.viewmodel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import com.androidsolutions.viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val sampleList by lazy {
        prepareList()
    }

    private fun prepareList() = arrayListOf("A","B","C")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initClicks()
    }

    private fun initClicks() {
        arrayOf(
            binding.btnInit,
            binding.btnInit2, binding.btnInit3, binding.btnInit4
        ).forEach {
            it.setOnClickListener(onClick)
        }
    }

    private val onClick = View.OnClickListener {
        when(it){
            binding.btnInit -> startActivity(Intent(this,DemoActivity::class.java).apply {
                putExtra("type","just_init")
            })
            binding.btnInit2 -> startActivity(Intent(this,DemoActivity::class.java).apply {
                putExtra("type","init_with_params")
                putExtra("content","Initializing viewmodel with params using Custom ViewModel Factory")
            })
            binding.btnInit3 -> startActivity(Intent(this,DemoActivity::class.java).apply {
                putExtra("type","using_by_viewModels")
            })
            binding.btnInit4 -> startActivity(Intent(this,DemoActivity::class.java).apply {
                putExtra("type","using_by_viewModels_with_params")
            })
        }
    }
}
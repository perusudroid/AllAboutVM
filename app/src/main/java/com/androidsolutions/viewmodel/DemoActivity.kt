package com.androidsolutions.viewmodel

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.androidsolutions.viewmodel.databinding.ActivityDemoBinding

class DemoActivity : AppCompatActivity() {

    private val type by lazy { intent?.extras?.getString("type") }
    private val binding by lazy { ActivityDemoBinding.inflate(layoutInflater) }

    private var demoViewModel: DemoViewModel?=null
    private val demoViewModelBy : DemoViewModel by viewModels()
    private val demoViewModelByWithParams : DemoViewModel2 by viewModels {
        VMFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.tvTxt.text = type
        initVM()
        subscribeToObservers()
        assignValues()
    }

    private fun initVM() {
        when(type){
            "just_init" -> {
                demoViewModel = ViewModelProvider(this)[DemoViewModel::class.java]
            }
            "init_with_params" -> {
                demoViewModel = ViewModelProvider(
                    this,
                    ViewModelFactory.getInstance(intent?.extras)
                )[DemoViewModel::class.java]
            }
            "using_by_viewModels","using_by_viewModels_with_params" ->{
                // no need to init here
            }
        }
    }

    private fun subscribeToObservers() {
        demoViewModel?.content?.observe(this){
            binding.tvContent.text = it
        }
        demoViewModelBy.content.observe(this){
            binding.tvContent.text = it
        }
        demoViewModelByWithParams.content.observe(this){
            binding.tvContent.text = it
        }
    }

    private fun assignValues() {
        when(type){
            "just_init" -> demoViewModel?.setValue("Just normal ViewModel initialization")
            "init_with_params" -> demoViewModel?.useBundleData()
            "using_by_viewModels" -> demoViewModelBy.setValue("ViewModel initialization using Kotlin extension function (by viewModels)")
            "using_by_viewModels_with_params" -> demoViewModelByWithParams.getContent()
        }
    }
}
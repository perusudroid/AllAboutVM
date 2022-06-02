package com.androidsolutions.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DemoViewModel2(private val iDemoRepo: IDemoRepo) : ViewModel() {

    private val _content = MutableLiveData<String?>()
    val content : LiveData<String?>
        get() = _content

    fun getContent(){
        _content.value = iDemoRepo.getData()
    }

}
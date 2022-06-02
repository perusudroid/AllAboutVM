package com.androidsolutions.viewmodel

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DemoViewModel(private val bundle: Bundle?=null) : ViewModel() {

    private val _content = MutableLiveData<String?>()
    val content : LiveData<String?>
        get() = _content

    fun setValue(newData : String?){
        _content.value = newData
    }

    fun useBundleData() {
            setValue(bundle?.getString("content"))
    }

}
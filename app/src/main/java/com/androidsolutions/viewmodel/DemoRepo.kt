package com.androidsolutions.viewmodel

class DemoRepo : IDemoRepo {
    override fun getData() = "ViewModel initialization with repo instance using Kotlin extension function (by viewModels)"
}
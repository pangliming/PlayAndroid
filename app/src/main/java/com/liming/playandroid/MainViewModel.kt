package com.liming.playandroid

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author pangliming
 *
 */
class MainViewModel : ViewModel() {
    private val mainLiveData = MutableLiveData<Int>()

    fun getPage(): Int? {
        return mainLiveData.value
    }

    fun setPage(page: Int) {
        mainLiveData.value = page
    }
}
package com.liming.playandroid.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * @author pangliming
 *
 */
class HomePageViewModelFactory constructor(private val homeRepository: HomeRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomePageModel(homeRepository) as T
    }

}
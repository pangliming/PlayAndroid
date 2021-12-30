package com.liming.playandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.liming.playandroid.home.HomePageModel
import com.liming.playandroid.home.HomePageViewModelFactory
import com.liming.playandroid.home.HomeRepository



class MainActivity : AppCompatActivity() {
    lateinit var homePageModel: HomePageModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        homePageModel = ViewModelProvider(
            this,
            HomePageViewModelFactory(HomeRepository())
        )[HomePageModel::class.java]

    }


}
package com.liming.playandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.liming.playandroid.base.BaseActivity
import com.liming.playandroid.databinding.ActivityMainBinding
import com.liming.playandroid.home.HomePageModel
import com.liming.playandroid.home.HomePageViewModelFactory
import com.liming.playandroid.home.HomeRepository



class MainActivity : BaseActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    private val mainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(activityMainBinding.root)
        activityMainBinding.homeView.init(supportFragmentManager, mainViewModel)

    }


}
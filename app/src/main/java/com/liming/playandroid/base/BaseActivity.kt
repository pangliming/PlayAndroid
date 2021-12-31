package com.liming.playandroid.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * @author pangliming
 * 基类Activity
 */
abstract class BaseActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
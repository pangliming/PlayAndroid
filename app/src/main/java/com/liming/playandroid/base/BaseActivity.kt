package com.liming.playandroid.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.liming.playandroid.util.transParentStatusBar

/**
 * @author pangliming
 * 基类Activity
 */
abstract class BaseActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        transParentStatusBar(this)
    }
}
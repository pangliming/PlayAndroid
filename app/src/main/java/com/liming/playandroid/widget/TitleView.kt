package com.liming.playandroid.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.liming.playandroid.databinding.LayoutTitleViewBinding

/**
 * @author pangliming
 *
 */
class TitleView @JvmOverloads constructor(context: Context?, attr: AttributeSet?, defStyleAttr: Int = 0) :
    RelativeLayout(context, attr, defStyleAttr) {

        init {
            val binding = LayoutTitleViewBinding.inflate(LayoutInflater.from(context), this, true)
        }
}
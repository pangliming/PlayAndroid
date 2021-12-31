package com.liming.playandroid.widget

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.liming.playandroid.R
import com.liming.playandroid.databinding.LayoutHomeBottomViewTabBinding

/**
 * @author pangliming
 *
 */
class HomeBottomViewTabLayout @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    BaseHomeBottomViewTabLayout(context, attrs, defStyleAttr) {

    private lateinit var textViews: ArrayList<TextView>

    init {
        val binding = LayoutHomeBottomViewTabBinding.inflate(LayoutInflater.from(context),this, true)
        binding.apply {
            textViews =
                arrayListOf(tvHomeAtHome, tvHomeAtProject, tvProjectAtAccount, tvProjectAtMine)
        }

        for (tab in textViews!!) {
            tab.setOnClickListener(this)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_HomeAtHome -> changeFragment(0)
            R.id.tv_HomeAtProject -> changeFragment(1)
            R.id.tv_ProjectAtAccount -> changeFragment(2)
            R.id.tv_ProjectAtMine -> changeFragment(3)
        }
    }

    override fun changeFragment(index: Int) {
        super.changeFragment(index)
        for (j in textViews.indices) {
            textViews[j].isSelected = j == index

        }
    }

}
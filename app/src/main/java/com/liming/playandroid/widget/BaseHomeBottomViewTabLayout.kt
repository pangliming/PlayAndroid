package com.liming.playandroid.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.liming.playandroid.MainViewModel
import com.liming.playandroid.R
import com.liming.playandroid.account.AccountFragment
import com.liming.playandroid.home.HomeFragment
import com.liming.playandroid.mine.MineFragment
import com.liming.playandroid.project.ProjectFragment

/**
 * @author pangliming
 *
 */
abstract class BaseHomeBottomViewTabLayout @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    LinearLayout(context, attrs, defStyleAttr), View.OnClickListener {
    private val homeFragment by lazy { HomeFragment() }
    private val projectFragment by lazy { ProjectFragment() }
    private val accountFragment by lazy { AccountFragment() }
    private val mineFragment by lazy { MineFragment() }
    private lateinit var viewModel: MainViewModel
    private lateinit var fm: FragmentManager
    private var fragments: ArrayList<Fragment>? = null
    private var currentFragment: Fragment? = null
    fun init(fm: FragmentManager, viewModel: MainViewModel) {
        this.viewModel = viewModel
        this.fm = fm
        if (fragments == null) {
            fragments = arrayListOf()
            fragments?.apply {
                //加入fragment
                getCurrentFragment(0)?.let { add(it) }
                getCurrentFragment(1)?.let { add(it) }
                getCurrentFragment(2)?.let { add(it) }
                getCurrentFragment(3)?.let { add(it) }
            }
        }
        changeFragment(viewModel.getPage() ?: 0)
    }

    /*切换Fragment*/
    protected open fun changeFragment(index: Int) {
        viewModel.setPage(index)
        val targetFragment = fragments!![index]
        val translation = fm!!.beginTransaction()
        translation.apply {
            currentFragment?.let { hide(it) }
            setReorderingAllowed(true)
            //显示当前Fragment
            if (!targetFragment.isAdded) {
                add(R.id.fl_home_container, targetFragment).commit()
            } else {
                show(targetFragment).commit()
            }
        }
        currentFragment = targetFragment
    }

    private fun getCurrentFragment(index: Int): Fragment? {
        return when (index) {
            0 -> {
                homeFragment
            }
            1 -> {
                projectFragment
            }
            2 -> {
                accountFragment
            }
            3 -> {
                mineFragment
            }
            else -> null
        }
    }
}
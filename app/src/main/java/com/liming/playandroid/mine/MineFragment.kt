package com.liming.playandroid.mine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.liming.playandroid.base.BaseFragment
import com.liming.playandroid.databinding.FragmentMineBinding

/**
 * @author pangliming
 *
 */
class MineFragment:BaseFragment() {
    private lateinit var fragmentMineBinding: FragmentMineBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentMineBinding = FragmentMineBinding.inflate(inflater, container, false)
        return fragmentMineBinding.root
    }
}
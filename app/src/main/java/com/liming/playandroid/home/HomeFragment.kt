package com.liming.playandroid.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.liming.playandroid.base.BaseFragment
import com.liming.playandroid.databinding.FragmentHomeBinding

/**
 * @author pangliming
 *
 */
class HomeFragment:BaseFragment() {
    private lateinit var fragmentHomeBinding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return fragmentHomeBinding.root
    }
}
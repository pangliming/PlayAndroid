package com.liming.playandroid.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.liming.playandroid.base.BaseFragment
import com.liming.playandroid.databinding.FragmentAccountBinding

/**
 * @author pangliming
 *
 */
class AccountFragment : BaseFragment() {
    private lateinit var fragmentAccountBinding: FragmentAccountBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentAccountBinding = FragmentAccountBinding.inflate(inflater, container, false)
        return fragmentAccountBinding.root
    }
}
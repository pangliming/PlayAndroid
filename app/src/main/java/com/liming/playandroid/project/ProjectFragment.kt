package com.liming.playandroid.project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.liming.playandroid.base.BaseFragment
import com.liming.playandroid.databinding.FragmentProjectBinding

/**
 * @author pangliming
 *
 */
class ProjectFragment : BaseFragment() {
    private lateinit var fragmentProjectBinding: FragmentProjectBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentProjectBinding = FragmentProjectBinding.inflate(inflater, container, false)
        return fragmentProjectBinding.root
    }
}
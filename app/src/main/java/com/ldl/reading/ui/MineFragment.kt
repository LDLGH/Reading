package com.ldl.reading.ui

import com.ldl.reading.R.layout.fragment_mine
import com.ldl.reading.core.BaseFragment
import com.ldl.reading.viewmodel.MineViewModel

/**
 * 作者：LDL 创建时间：2019/9/18
 * 类说明：
 */
class MineFragment : BaseFragment<MineViewModel>() {

    override fun registerViewModel() = MineViewModel::class.java

    override fun getLayoutId(): Int = fragment_mine

    override fun initView() {
    }
}
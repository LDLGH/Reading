package com.ldl.reading.ui

import com.ldl.reading.R.layout.fragment_story
import com.ldl.reading.core.BaseFragment
import com.ldl.reading.viewmodel.StoryViewModel

/**
 * 作者：LDL 创建时间：2019/9/18
 * 类说明：
 */
class StoryFragment : BaseFragment<StoryViewModel>() {

    override fun registerViewModel() = StoryViewModel::class.java

    override fun getLayoutId(): Int = fragment_story

    override fun initView() {
    }
}
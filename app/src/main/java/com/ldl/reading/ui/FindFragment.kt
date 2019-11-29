package com.ldl.reading.ui

import com.ldl.reading.R.layout.fragment_find
import com.ldl.reading.core.BaseFragment
import com.ldl.reading.viewmodel.FindViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

/**
 * 作者：LDL 创建时间：2019/9/18
 * 类说明：
 */
class FindFragment : BaseFragment<FindViewModel>() , CoroutineScope by MainScope(){

    override fun registerViewModel() = FindViewModel::class.java

    override fun getLayoutId(): Int = fragment_find

    override fun initView() {
        launch {  }
    }

    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }

}
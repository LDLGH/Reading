package com.ldl.reading.ui

import androidx.fragment.app.Fragment
import com.blankj.utilcode.util.FragmentUtils
import com.blankj.utilcode.util.LogUtils
import com.ldl.reading.R
import com.ldl.reading.R.layout.activity_main
import com.ldl.reading.core.BaseActivity
import com.ldl.reading.viewmodel.MainViewModel
import com.ldl.reading.widget.MainMenuView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

/**
 * 作者：LDL 创建时间：2019/9/16
 * 类说明：
 */
class MainActivity : BaseActivity<MainViewModel>(), MainMenuView.MenuListener {

    private var mFragments = arrayListOf<Fragment>()

    override fun registerViewModel() = MainViewModel::class.java

    override fun getLayoutId(): Int = activity_main

    private var mainScope = MainScope()

    override fun initView() {
        ll_menu.setMenuListener(this)
        mFragments.add(FindFragment())
        mFragments.add(BookshelfFragment())
        mFragments.add(StoryFragment())
        mFragments.add(MineFragment())
        FragmentUtils.add(supportFragmentManager, mFragments, R.id.fl_container, 0)
        GlobalScope.launch {
            LogUtils.e(Thread.currentThread().name)
            onCoroutineScope()
        }
        mainScope.launch {
            LogUtils.e(Thread.currentThread().name)
            onCoroutineScope()
        }
    }

    override fun onMenuListener(menu: Int) {
        FragmentUtils.showHide(menu, mFragments)
    }

    suspend fun onCoroutineScope() = withContext(Dispatchers.Main) {
        LogUtils.e(Thread.currentThread().name)
        withContext(Dispatchers.IO) {
            LogUtils.e(Thread.currentThread().name)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mainScope.cancel()
    }

}
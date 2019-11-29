package com.ldl.reading.ui

import com.ldl.reading.R.layout.fragment_bookshelf
import com.ldl.reading.core.BaseFragment
import com.ldl.reading.viewmodel.BookshelfViewModel

/**
 * 作者：LDL 创建时间：2019/9/18
 * 类说明：
 */
class BookshelfFragment : BaseFragment<BookshelfViewModel>() {

    override fun registerViewModel() = BookshelfViewModel::class.java

    override fun getLayoutId(): Int = fragment_bookshelf

    override fun initView() {
    }
}
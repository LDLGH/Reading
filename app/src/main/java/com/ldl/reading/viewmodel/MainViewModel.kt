package com.ldl.reading.viewmodel

import com.ldl.reading.core.BaseViewModel
import com.ldl.reading.model.MainModelImpl

/**
 * 作者：LDL 创建时间：2019/9/16
 * 类说明：
 */

interface IMainViewModel {

    fun getData()

}

class MainViewModel : BaseViewModel(), IMainViewModel {

    private var mainModel: MainModelImpl? = null

    init {
        mainModel = MainModelImpl()
    }

    override fun getData() {
        mainModel?.getData()
    }
}


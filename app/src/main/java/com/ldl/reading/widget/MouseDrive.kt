package com.ldl.reading.widget

import com.blankj.utilcode.util.LogUtils

/**
 * 作者：LDL 创建时间：2019/10/29
 * 类说明：
 */
object MouseDrive {

    init {
        LogUtils.e("狗糖是SB")
    }

    fun fixMouse(desc: String) {
        if (desc == "狗糖鼠标坏了") {
            LogUtils.e("换电脑")
            return
        }
    }

}
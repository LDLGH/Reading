package com.ldl.reading.core

/**
 * 作者：LDL 创建时间：2019/9/19
 * 类说明：
 */
interface IBaseView<out P : BaseViewModel> {

    fun registerViewModel(): Class<out P>
}
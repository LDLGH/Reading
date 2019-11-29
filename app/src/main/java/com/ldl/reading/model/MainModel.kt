package com.ldl.reading.model

import android.widget.Button
import android.widget.TextView
import com.ldl.reading.core.BaseModel

/**
 * 作者：LDL 创建时间：2019/10/8
 * 类说明：
 */
interface MainModel {

    fun getData()
}

class MainModelImpl : BaseModel(), MainModel {

    override fun getData() {

    }

    fun <T> fill(array: Array<in T>, t: T) {
        array[0] = t
    }

    fun <T> copy(array: Array<in T>, array2: Array<out T>) {
        array2.forEachIndexed { index, t ->
            array[index] = t
        }
    }
}
package com.ldl.reading.widget.measure

import android.content.Context
import android.util.AttributeSet
import android.view.View

/**
 * 作者：LDL 创建时间：2019/12/6
 * 类说明：
 */
class CustomMeasureView constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val w = resolveSize(200, widthMeasureSpec)
        val h = resolveSize(200, heightMeasureSpec)
        setMeasuredDimension(w, h)
    }

}
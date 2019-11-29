package com.ldl.reading.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.blankj.utilcode.util.ConvertUtils

/**
 * 作者：LDL 创建时间：2019/11/29
 * 类说明：
 */
class ShadowLayerView constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val mText = "ShadowLayerView"

    init {
        mPaint.setShadowLayer(10f, 0f, 0f, Color.BLUE)
        mPaint.textSize = ConvertUtils.sp2px(30f).toFloat()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawText(mText, 100f, 100f, mPaint)
    }

}
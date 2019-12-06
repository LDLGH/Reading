package com.ldl.reading.widget.objectanim

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * 作者：LDL 创建时间：2019/12/5
 * 类说明：
 */
class ArgbEvaluatorView constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private var mPaint = Paint()

    private var color = -0x10000
        set(value) {
            field = value
            invalidate()
        }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val width = width
        val height = height
        mPaint.color = color
        canvas!!.drawCircle(width / 2.toFloat(), height / 2.toFloat(), width / 6.toFloat(), mPaint)
    }
}
package com.ldl.reading.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * 作者：LDL 创建时间：2019/11/29
 * 类说明：
 */
class StrokeCapView constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        mPaint.strokeWidth = 20f
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val size = getSize(widthMeasureSpec)
        setMeasuredDimension(size, size)
    }

    private fun getSize(size: Int): Int {
        var default = 100
        val mode = MeasureSpec.getMode(size)
        if (mode != MeasureSpec.UNSPECIFIED) {
            default = MeasureSpec.getSize(size)
        }
        return default
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mPaint.strokeCap = Paint.Cap.BUTT
        canvas?.drawLine(0f, 0f, 100f, 0f, mPaint)
        mPaint.strokeCap = Paint.Cap.ROUND
        canvas?.drawLine(0f, 50f, 100f, 50f, mPaint)
        mPaint.strokeCap = Paint.Cap.SQUARE
        canvas?.drawLine(0f, 100f, 100f, 100f, mPaint)
    }
}
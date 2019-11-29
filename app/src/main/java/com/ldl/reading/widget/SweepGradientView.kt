package com.ldl.reading.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * 作者：LDL 创建时间：2019/11/29
 * 类说明：
 */
class SweepGradientView constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        val shader = SweepGradient(
            300f, 300f,
            Color.parseColor("#E91E63"), Color.parseColor("#2196F3")
        )
        mPaint.shader = shader
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
        canvas?.drawCircle(300f, 300f, 200f, mPaint)
    }
}

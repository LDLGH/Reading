package com.ldl.reading.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 * 作者：LDL 创建时间：2019/11/29
 * 类说明：
 */
class StrokeMiterView constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val mPath = Path()

    init {
        mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = 40f
        mPath.moveTo(100f, 100f)
        mPath.lineTo(200f, 100f)
        mPath.rLineTo(-120f, 120f)
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

        canvas?.let {
            it.save()

            mPaint.strokeMiter = 1f
            it.drawPath(mPath, mPaint)
            it.translate(300f, 0f)

            mPaint.strokeMiter = 3f
            it.drawPath(mPath, mPaint)
            it.translate(300f, 0f)

            mPaint.strokeMiter = 5f
            it.drawPath(mPath, mPaint)
            it.restore()
        }

    }
}
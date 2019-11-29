package com.ldl.reading.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.blankj.utilcode.util.ScreenUtils

/**
 * 作者：LDL 创建时间：2019/11/27
 * 类说明：
 */
class CircleView constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private var mPaint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mPaint.isAntiAlias = true

        mPaint.style = Paint.Style.FILL
        mPaint.color = Color.BLACK
        canvas?.drawCircle(200f, 100f, 100f, mPaint)

        mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = 10f
        canvas?.drawCircle(500f, 120f + 5, 120f, mPaint)

        mPaint.style = Paint.Style.FILL
        mPaint.color = Color.BLUE
        canvas?.drawCircle(200f, 400f, 100f, mPaint)

        mPaint.style = Paint.Style.STROKE
        mPaint.color = Color.BLACK
        mPaint.strokeWidth = 20f
        canvas?.drawCircle(500f, 420f, 120f, mPaint)

        mPaint.style = Paint.Style.FILL
        mPaint.color = Color.GRAY
        canvas?.drawLine(0f, 550f, ScreenUtils.getScreenWidth().toFloat(), 560f, mPaint)
    }
}
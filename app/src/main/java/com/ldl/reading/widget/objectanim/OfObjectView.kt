package com.ldl.reading.widget.objectanim

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View

/**
 * 作者：LDL 创建时间：2019/12/5
 * 类说明：
 */
class OfObjectView constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    companion object {
        const val RADIUS = 40f
    }

    private var mPaint = Paint()
    private var position = PointF()
        set(value) {
            field = value
            invalidate()
        }

    init {
        mPaint.color = Color.parseColor("#009688")
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val innerPaddingLeft: Float = RADIUS * 1
        val interPaddingRight: Float = RADIUS * 1
        val interPaddingTop: Float = RADIUS * 1
        val interPaddingBottom: Float = RADIUS * 3
        val width: Float = width - innerPaddingLeft - interPaddingRight - RADIUS * 2
        val height: Float = height - interPaddingTop - interPaddingBottom - RADIUS * 2
        canvas?.drawCircle(
            innerPaddingLeft + RADIUS + width * position.x,
            interPaddingTop + RADIUS + height * position.y,
            RADIUS,
            mPaint
        )
    }
}
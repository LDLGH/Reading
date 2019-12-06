package com.ldl.reading.widget.draworder

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

/**
 * 作者：LDL 创建时间：2019/12/3
 * 类说明：
 */
class BeforeOnDrawView constructor(
    context: Context,
    attrs: AttributeSet? = null
) : AppCompatTextView(context, attrs) {

    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var bounds = RectF()

    init {
        paint.color = Color.parseColor("#FFC107")
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.apply {
            bounds.left = layout.getLineLeft(1)
            bounds.right = layout.getLineRight(1)
            bounds.top = layout.getLineTop(1).toFloat()
            bounds.bottom = layout.getLineBottom(1).toFloat()
            drawRect(bounds, paint)
            bounds.left = layout.getLineLeft(layout.lineCount - 3)
            bounds.right = layout.getLineRight(layout.lineCount - 3)
            bounds.top = layout.getLineTop(layout.lineCount - 3).toFloat()
            bounds.bottom = layout.getLineBottom(layout.lineCount - 3).toFloat()
            drawRect(bounds, paint)
        }
        super.onDraw(canvas)
    }

}
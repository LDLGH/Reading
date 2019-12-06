package com.ldl.reading.widget.draworder

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.ldl.reading.R

/**
 * 作者：LDL 创建时间：2019/12/4
 * 类说明：
 */
class DispatchDrawLayout constructor(
    context: Context,
    attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        paint.color = ContextCompat.getColor(context, R.color.colorAccent)
        setWillNotDraw(false)
    }

    override fun dispatchDraw(canvas: Canvas?) {
        super.dispatchDraw(canvas)
        canvas?.apply {
            drawCircle(100f, 100f, 20f, paint)
            drawCircle(200f, 200f, 50f, paint)
            drawCircle(100f, 300f, 20f, paint)
        }
    }
}
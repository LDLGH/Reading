package com.ldl.reading.widget.drawtext

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * 作者：LDL 创建时间：2019/12/2
 * 类说明：
 */
class MeasureTextView constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private var paint1 = Paint(Paint.ANTI_ALIAS_FLAG)
    private var paint2 = Paint(Paint.ANTI_ALIAS_FLAG)
    private var text1 = "三个月内你胖了"
    private var text2 = "4.5"
    private var text3 = "公斤"

    init {
        paint1.textSize = 60f
        paint2.textSize = 120f
        paint2.color = Color.parseColor("#E91E63")
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.let {
            it.drawText(text1, 50f, 200f, paint1)
            it.drawText(text2, 50 + paint1.measureText(text1), 200f, paint2)
            it.drawText(
                text3,
                50 + paint1.measureText(text1) + paint2.measureText(text2),
                200f,
                paint1
            )
        }
    }
}
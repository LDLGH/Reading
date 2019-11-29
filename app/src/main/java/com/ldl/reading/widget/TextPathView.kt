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
class TextPathView constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var pathPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var textPath = Path()
    private var text = "Hello HenCoder"

    init {
        paint.textSize = 120f
        pathPaint.textSize = 120f

        // 使用 Paint.getTextPath() 来获取文字的 Path
        pathPaint.getTextPath(text, 0, text.length, 50f, 400f, textPath)
        pathPaint.style = Paint.Style.STROKE
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawText(text, 50f, 200f, paint)
        canvas?.drawPath(textPath, pathPaint)
    }

}
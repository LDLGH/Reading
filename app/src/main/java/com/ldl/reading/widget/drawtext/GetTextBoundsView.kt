package com.ldl.reading.widget.drawtext

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

/**
 * 作者：LDL 创建时间：2019/12/2
 * 类说明：
 */
class GetTextBoundsView constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private var paint1 = Paint(Paint.ANTI_ALIAS_FLAG)
    private var paint2 = Paint(Paint.ANTI_ALIAS_FLAG)

    private var top1 = 200
    private var bottom1 = 400

    private val yOffsets = IntArray(6)
    private val texts = arrayOf("A", "a", "J", "j", "Â", "â")
    private val rect: Rect

    init {
        paint1.style = Paint.Style.STROKE
        paint1.strokeWidth = 20f
        paint1.color = Color.parseColor("#E91E63")
        paint2.textSize = 160f
        rect = Rect()

        for (i in texts.indices) {
            val text = texts[i]
            paint2.getTextBounds(text, 0, text.length, rect)
            yOffsets[i] = -(rect.top + rect.bottom)
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.let {
            it.drawRect(50f, top1.toFloat(), (width - 50).toFloat(), bottom1.toFloat(), paint1)
            for (i in texts.indices) {
                val middle = (top1 + bottom1 + yOffsets[i]) / 2
                canvas.drawText(texts[i], 100f + i * 100, middle.toFloat(), paint2)
            }
        }
    }
}
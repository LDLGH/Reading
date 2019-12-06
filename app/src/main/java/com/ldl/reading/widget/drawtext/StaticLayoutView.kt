package com.ldl.reading.widget.drawtext

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View

/**
 * 作者：LDL 创建时间：2019/12/2
 * 类说明：
 */
class StaticLayoutView constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private val staticLayout: StaticLayout
    private val staticLayout2: StaticLayout

    init {
        val text1 = "Lorem Ipsum is simply dummy text of the printing and typesetting industry."
        val textPaint = TextPaint()
        textPaint.textSize = 30f
        textPaint.isFakeBoldText = true
        staticLayout = StaticLayout(
            text1,
            textPaint,
            600,
            Layout.Alignment.ALIGN_NORMAL,
            1f,
            0f,
            true
        )
        val text2 = "a\nbc\ndefghi\njklm\nnopqrst\nuvwx\nyz"
        staticLayout2 = StaticLayout(
            text2,
            textPaint,
            400,
            Layout.Alignment.ALIGN_NORMAL,
            1f,
            0f,
            true
        )
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.let {
            it.save()
            it.translate(50f, 100f)
            staticLayout.draw(canvas)
            it.translate(0f, 200f)
            staticLayout2.draw(canvas)
            canvas.restore()
        }
    }

}
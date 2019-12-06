package com.ldl.reading.widget.draworder

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import com.ldl.reading.R

/**
 * 作者：LDL 创建时间：2019/12/4
 * 类说明：
 */
class BeforeDrawView constructor(
    context: Context,
    attrs: AttributeSet? = null
) : AppCompatEditText(context, attrs) {

    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        paint.color = Color.parseColor("#FFC107")
    }

    override fun draw(canvas: Canvas?) {
        canvas?.apply {
            drawColor(ContextCompat.getColor(context, R.color.colorAccent))
        }
        super.draw(canvas)
    }
}
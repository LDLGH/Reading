package com.ldl.reading.widget.draworder

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.ldl.reading.R

/**
 * 作者：LDL 创建时间：2019/12/3
 * 类说明：
 */
class AfterOnDrawView constructor(
    context: Context,
    attrs: AttributeSet? = null
) : AppCompatImageView(context, attrs) {

    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        paint.color = Color.parseColor("#FFC107")
        paint.textSize = 28f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.apply {
            save()
            concat(imageMatrix)
            val bounds = drawable.bounds
            drawText(
                resources.getString(
                    R.string.image_size,
                    bounds.width(),
                    bounds.height()
                ), 20f, 40f, paint
            )
            restore()
        }

    }
}
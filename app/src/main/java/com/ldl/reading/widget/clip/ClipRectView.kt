package com.ldl.reading.widget.clip

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.ldl.reading.R

/**
 * 作者：LDL 创建时间：2019/12/2
 * 类说明：
 */
class ClipRectView constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val left = (width - bitmap.width) / 2
        val top = (height - bitmap.height) / 2
        canvas?.apply {
            save()
            clipRect(left + 50, top + 50, left + 300, top + 200)
            drawBitmap(bitmap, left.toFloat(), top.toFloat(), paint)
            restore()
        }
    }
}
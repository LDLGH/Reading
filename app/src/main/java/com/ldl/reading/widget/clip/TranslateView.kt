package com.ldl.reading.widget.clip

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.ldl.reading.R

/**
 * 作者：LDL 创建时间：2019/12/3
 * 类说明：
 */
class TranslateView constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    private var point1 = Point(200, 200)


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.apply {
            drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)

            save()
            translate(200f, 0f)
            drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
            restore()

            save()
            translate(200f, 300f)
            rotate(45f, 200f, 200f)
            drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
            restore()

            save()
            translate(200f, 600f)
            scale(0.5f, 0.8f, 200f, 200f)
            drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
            restore()

            save()
            translate(200f, 800f)
            skew(0f, -0.5f)
            drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
            restore()
        }
    }
}
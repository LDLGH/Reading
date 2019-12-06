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
class ClipPathView constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    private var point1 = Point(200, 200)
    private var point2 = Point(200, 600)


    private val path = Path()
    private val path2 = Path()

    init {
        path.addCircle(point1.x.toFloat() + 200, point1.y.toFloat() + 200, 150f, Path.Direction.CW)
        path2.addCircle(point2.x.toFloat() + 200, point2.y.toFloat() + 200, 150f, Path.Direction.CW)
        path2.fillType = Path.FillType.INVERSE_WINDING
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.apply {
            save()
            clipPath(path)
            drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
            restore()

            save()
            clipPath(path2)
            drawBitmap(bitmap, point2.x.toFloat(), point2.y.toFloat(), paint)
            restore()
        }
    }
}
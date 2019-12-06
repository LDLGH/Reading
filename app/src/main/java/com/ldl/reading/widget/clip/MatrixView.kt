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
class MatrixView constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    private var point1 = Point(200, 200)
    private var point2 = Point(200, 600)

    private val mMatrix = Matrix()

    private val left = 200f
    private val top = 200f
    private val right = 600f
    private val bottom = 600f

    init {
        val pointsSrc = arrayOf(left, top, right, top, left, bottom, right, bottom)
        val pointsDst = arrayOf(
            left - 10,
            top + 50,
            right + 120,
            top - 90,
            left + 20,
            bottom + 30,
            right + 20,
            bottom + 60
        )
        mMatrix.reset()
        mMatrix.setPolyToPoly(pointsSrc.toFloatArray(), 0, pointsDst.toFloatArray(), 0, 4)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.apply {

            drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)

            save()
            concat(mMatrix)
            drawBitmap(bitmap, point2.x.toFloat(), point2.y.toFloat(), paint)
            restore()
        }
    }

}
package com.ldl.reading.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.ldl.reading.R

/**
 * 作者：LDL 创建时间：2019/11/29
 * 类说明：
 */
class ColorMatrixColorFilterView constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val bitmap: Bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.batman)

    init {
        val colorMatrix = ColorMatrix()
        colorMatrix.setSaturation(0f)
        val colorFilter = ColorMatrixColorFilter(colorMatrix)
        mPaint.colorFilter = colorFilter
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val size = getSize(widthMeasureSpec)
        setMeasuredDimension(size, size)
    }

    private fun getSize(size: Int): Int {
        var default = 100
        val mode = MeasureSpec.getMode(size)
        if (mode != MeasureSpec.UNSPECIFIED) {
            default = MeasureSpec.getSize(size)
        }
        return default
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawBitmap(bitmap, 200f, 200f, mPaint)
    }
}
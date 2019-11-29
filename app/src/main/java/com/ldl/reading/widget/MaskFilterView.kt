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
class MaskFilterView constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val mBitmap = BitmapFactory.decodeResource(context.resources, R.drawable.what_the_fuck)
    private val blurMaskFilter: MaskFilter
    private val blurMaskFilter2: MaskFilter
    private val blurMaskFilter3: MaskFilter
    private val blurMaskFilter4: MaskFilter

    init {
        blurMaskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.NORMAL)
        blurMaskFilter2 = BlurMaskFilter(50f, BlurMaskFilter.Blur.INNER)
        blurMaskFilter3 = BlurMaskFilter(50f, BlurMaskFilter.Blur.OUTER)
        blurMaskFilter4 = BlurMaskFilter(50f, BlurMaskFilter.Blur.SOLID)
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        // 第一个：NORMAL
        mPaint.maskFilter = blurMaskFilter
        canvas?.drawBitmap(mBitmap, 100f, 50f, mPaint)

        // 第二个：INNER
        mPaint.maskFilter = blurMaskFilter2
        canvas?.drawBitmap(mBitmap, (mBitmap.width + 200).toFloat(), 50f, mPaint)

        // 第三个：OUTER
        mPaint.maskFilter = blurMaskFilter4
        canvas?.drawBitmap(mBitmap, 100f, (mBitmap.height + 100).toFloat(), mPaint)

        // 第四个：SOLID
        mPaint.maskFilter = blurMaskFilter4
        canvas?.drawBitmap(
            mBitmap,
            (mBitmap.width + 200).toFloat(),
            (mBitmap.height + 100).toFloat(),
            mPaint
        )
    }
}
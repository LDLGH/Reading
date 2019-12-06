package com.ldl.reading.widget.objectanim

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.blankj.utilcode.util.ConvertUtils
import com.ldl.reading.R

/**
 * 作者：LDL 创建时间：2019/12/6
 * 类说明：
 */
class KeyframeView constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private var mArcPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var mTextPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var rectF = RectF()
    private val radius = ConvertUtils.dp2px(80f)

    private var progress: Float = 0f
        set(value) {
            field = value
            invalidate()
        }


    init {
        mArcPaint.color = ContextCompat.getColor(context, R.color.colorAccent)
        mArcPaint.style = Paint.Style.STROKE
        mArcPaint.strokeCap = Paint.Cap.ROUND
        mArcPaint.strokeWidth = ConvertUtils.dp2px(15f).toFloat()

        mTextPaint.textSize = ConvertUtils.sp2px(40f).toFloat()
        mTextPaint.textAlign = Paint.Align.CENTER
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val rX = width / 2
        val rY = height / 2
        canvas?.apply {
            rectF.apply {
                top = (rY - radius).toFloat()
                left = (rX - radius).toFloat()
                right = (rX + radius).toFloat()
                bottom = (rY + radius).toFloat()
            }
            drawArc(rectF, -90f, progress, false, mArcPaint)

            val text = (progress / 3.6).toInt()
            drawText(
                "$text%",
                rX.toFloat(),
                rY - (mTextPaint.ascent() + mTextPaint.descent()) / 2,
                mTextPaint
            )
        }
    }
}
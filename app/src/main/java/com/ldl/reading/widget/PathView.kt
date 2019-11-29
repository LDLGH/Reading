package com.ldl.reading.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.blankj.utilcode.util.ConvertUtils
import com.ldl.reading.R

/**
 * 作者：LDL 创建时间：2019/11/27
 * 类说明：
 */
class PathView constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private var mPaint = Paint()
    private var mPath = Path()

    init {
        mPaint.color = ContextCompat.getColor(context, R.color.colorAccent)
        mPaint.style = Paint.Style.FILL
        mPath.addArc(200f, 200f, 400f, 400f, -225f, 225f)
        mPath.arcTo(400f, 200f, 600f, 400f, -180f, 225f, false)
        mPath.lineTo(400f, 542f)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawPath(mPath, mPaint)
    }

}
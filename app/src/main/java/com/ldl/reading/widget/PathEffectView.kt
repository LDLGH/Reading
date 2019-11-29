package com.ldl.reading.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * 作者：LDL 创建时间：2019/11/29
 * 类说明：
 */
class PathEffectView constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val mPath = Path()
    private val cornerPathEffect: PathEffect
    private val discretePathEffect: PathEffect
    private val dashPathEffect: PathEffect
    private val pathDashPathEffect: PathEffect
    private val sumPathEffect: PathEffect
    private val composePathEffect: PathEffect

    init {
        mPaint.style = Paint.Style.STROKE

        mPath.moveTo(50f, 100f)
        mPath.rLineTo(50f, 100f)
        mPath.rLineTo(80f, -150f)
        mPath.rLineTo(100f, 100f)
        mPath.rLineTo(70f, -120f)
        mPath.rLineTo(150f, 80f)

        cornerPathEffect = CornerPathEffect(20f)
        discretePathEffect = DiscretePathEffect(20f, 5f)
        dashPathEffect = DashPathEffect(floatArrayOf(20f, 10f, 5f, 10f), 0f)

        val dashPath = Path()
        dashPath.lineTo(20f, 30f)
        dashPath.lineTo(40f, 0f)
        dashPath.close()
        pathDashPathEffect =
            PathDashPathEffect(dashPath, 40f, 0f, PathDashPathEffect.Style.TRANSLATE)
        sumPathEffect = SumPathEffect(dashPathEffect, discretePathEffect)
        composePathEffect = ComposePathEffect(dashPathEffect, discretePathEffect)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // 使用 Paint.setPathEffect() 来设置不同的 PathEffect

        // 第一处：CornerPathEffect
        mPaint.pathEffect = cornerPathEffect
        canvas?.drawPath(mPath, mPaint)

        canvas?.save()
        canvas?.translate(500f, 0f)
        // 第二处：DiscretePathEffect
        mPaint.pathEffect = discretePathEffect
        canvas?.drawPath(mPath, mPaint)
        canvas?.restore()

        canvas?.save()
        canvas?.translate(0f, 200f)
        // 第三处：DashPathEffect
        mPaint.pathEffect = dashPathEffect
        canvas?.drawPath(mPath, mPaint)
        canvas?.restore()

        canvas?.save()
        canvas?.translate(500f, 200f)
        // 第四处：PathDashPathEffect
        mPaint.pathEffect = pathDashPathEffect
        canvas?.drawPath(mPath, mPaint)
        canvas?.restore()

        canvas?.save()
        canvas?.translate(0f, 400f)
        // 第五处：SumPathEffect
        mPaint.pathEffect = sumPathEffect
        canvas?.drawPath(mPath, mPaint)
        canvas?.restore()

        canvas?.save()
        canvas?.translate(500f, 400f)
        // 第六处：ComposePathEffect
        mPaint.pathEffect = composePathEffect
        canvas?.drawPath(mPath, mPaint)
        canvas?.restore()
    }

}
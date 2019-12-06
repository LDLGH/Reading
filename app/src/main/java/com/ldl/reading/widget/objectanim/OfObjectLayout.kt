package com.ldl.reading.widget.objectanim

import android.animation.ObjectAnimator
import android.animation.TypeEvaluator
import android.content.Context
import android.graphics.PointF
import android.util.AttributeSet
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.RelativeLayout
import com.ldl.reading.R


/**
 * 作者：LDL 创建时间：2019/12/6
 * 类说明：
 */
class OfObjectLayout constructor(
    context: Context,
    attrs: AttributeSet? = null
) : RelativeLayout(context, attrs) {

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        val view = findViewById<OfObjectView>(R.id.view)
        val button = findViewById<Button>(R.id.button)

        val animator = ObjectAnimator.ofObject(
            view,
            "position",
            PointFEvaluator(),
            PointF(0f, 0f),
            PointF(1f, 1f)
        )
        animator.duration = 3000
        animator.interpolator = LinearInterpolator()
        button.setOnClickListener {
            animator.start()
        }
    }


    private class PointFEvaluator : TypeEvaluator<PointF> {

        var newPoint = PointF()

        override fun evaluate(fraction: Float, startValue: PointF?, endValue: PointF?): PointF {
            val x = startValue!!.x +( fraction * (endValue!!.x - startValue.x))
            val y = startValue.y + (fraction * (endValue.y - startValue.y))
            newPoint.set(x, y)
            return newPoint
        }
    }
}
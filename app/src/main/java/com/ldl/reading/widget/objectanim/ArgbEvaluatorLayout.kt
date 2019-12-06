package com.ldl.reading.widget.objectanim

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.TypeEvaluator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.RelativeLayout
import com.ldl.reading.R


/**
 * 作者：LDL 创建时间：2019/12/5
 * 类说明：
 */
class ArgbEvaluatorLayout constructor(
    context: Context,
    attrs: AttributeSet? = null
) : RelativeLayout(context, attrs) {

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        val evaluatorView = findViewById<ArgbEvaluatorView>(R.id.evaluatorView)
        val button = findViewById<Button>(R.id.button)

        val animator = ObjectAnimator.ofInt(evaluatorView, "color", -0x10000, -0xff0100)
        animator.apply {
            duration = 2000
            interpolator = LinearInterpolator()
            setEvaluator(HsvEvaluator())
            repeatCount = 2
            repeatMode = ValueAnimator.REVERSE
        }
        button.setOnClickListener {
            animator.start()
        }
    }

    private class HsvEvaluator : TypeEvaluator<Int> {

        var startHsv = FloatArray(3)
        var endHsv = FloatArray(3)
        var outHsv = FloatArray(3)

        override fun evaluate(fraction: Float, startValue: Int?, endValue: Int?): Int {
            // 把 ARGB 转换成 HSV
            Color.colorToHSV(startValue!!, startHsv)
            Color.colorToHSV(endValue!!, endHsv)
            // 计算当前动画完成度（fraction）所对应的颜色值
            if (endHsv[0] - startHsv[0] > 180) {
                endHsv[0] = endHsv[0] - 360
            } else if (endHsv[0] - startHsv[0] < -180) {
                endHsv[0] = endHsv[0] + 360
            }
            outHsv[0] = startHsv[0] + (endHsv[0] - startHsv[0]) * fraction
            if (outHsv[0] > 360) {
                outHsv[0] = outHsv[0] - 360
            } else if (outHsv[0] < 0) {
                outHsv[0] = outHsv[0] + 360
            }
            outHsv[1] = startHsv[1] + (endHsv[1] - startHsv[1]) * fraction;
            outHsv[2] = startHsv[2] + (endHsv[2] - startHsv[2]) * fraction;

            // 计算当前动画完成度（fraction）所对应的透明度
            val alpha =
                startValue shr (24 + ((endValue shr 24 - startValue shr 24) * fraction)).toInt()

            // 把 HSV 转换回 ARGB 返回
            return Color.HSVToColor(alpha, outHsv)
        }
    }

}
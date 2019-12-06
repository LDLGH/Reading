package com.ldl.reading.widget.proanim

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.animation.AnticipateOvershootInterpolator
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import com.ldl.reading.R

/**
 * 作者：LDL 创建时间：2019/12/4
 * 类说明：
 */
class InterpolatorView constructor(
    context: Context,
    attrs: AttributeSet? = null
) : RelativeLayout(context, attrs) {

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        val imageView = findViewById<ImageView>(R.id.imageView)
        val button = findViewById<Button>(R.id.Translation)
        val animator = ObjectAnimator.ofFloat(imageView, "translationX", 500f)
        animator.interpolator = AnticipateOvershootInterpolator()
        animator.duration = 2000
        button.setOnClickListener {
            animator.start()
        }
    }

}
package com.ldl.reading.widget.proanim

import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.RelativeLayout
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.ldl.reading.R

/**
 * 作者：LDL 创建时间：2019/12/4
 * 类说明：
 */
class ObjectAnimatorLayout constructor(
    context: Context,
    attrs: AttributeSet? = null
) : RelativeLayout(context, attrs) {

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        val view = findViewById<ObjectAnimatorView>(R.id.view_object)
        val button = findViewById<Button>(R.id.Translation)
        val animator = ObjectAnimator.ofFloat(view, "progress", 0f, 360f)
        animator.duration = 2000
        animator.interpolator = FastOutSlowInInterpolator()
        button.setOnClickListener {
            animator.start()
        }
    }

}
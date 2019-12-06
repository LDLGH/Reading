package com.ldl.reading.widget.objectanim

import android.animation.Keyframe
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.RelativeLayout
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.ldl.reading.R

/**
 * 作者：LDL 创建时间：2019/12/6
 * 类说明：
 */
class KeyframeLayout constructor(
    context: Context,
    attrs: AttributeSet? = null
) : RelativeLayout(context, attrs) {

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        val view = findViewById<KeyframeView>(R.id.view)
        val button = findViewById<Button>(R.id.button)

        val keyframe1 = Keyframe.ofFloat(0f, 0f)
        val keyframe2 = Keyframe.ofFloat(0.5f, 360f)
        val keyframe3 = Keyframe.ofFloat(1f, 300f)
        val holder = PropertyValuesHolder.ofKeyframe(
            "progress",
            keyframe1,
            keyframe2,
            keyframe3
        )
        val animator = ObjectAnimator.ofPropertyValuesHolder(view, holder)
        animator.duration = 3000
        animator.interpolator = FastOutSlowInInterpolator()
        button.setOnClickListener {
            animator.start()
        }
    }
}
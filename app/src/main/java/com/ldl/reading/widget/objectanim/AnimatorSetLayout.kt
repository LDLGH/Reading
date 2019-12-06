package com.ldl.reading.widget.objectanim

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import com.ldl.reading.R

/**
 * 作者：LDL 创建时间：2019/12/6
 * 类说明：
 */
class AnimatorSetLayout constructor(
    context: Context,
    attrs: AttributeSet? = null
) : RelativeLayout(context, attrs) {

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        val view = findViewById<ImageView>(R.id.view)
        val button = findViewById<Button>(R.id.button)
        val animator1 = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f)
        val animator2 = ObjectAnimator.ofFloat(view, "translationX", -200f, 200f)
        val animator3 = ObjectAnimator.ofFloat(view, "rotation", 0f, 1080f)
        animator3.duration = 1000


        // 用 AnimatorSet 的方法来让三个动画协作执行
        // 要求 1： animator1 先执行，animator2 在 animator1 完成后立即开始
        // 要求 2： animator2 和 animator3 同时开始
        button.setOnClickListener {
            val animatorSet = AnimatorSet()
            animatorSet.play(animator1).before(animator2)
            animatorSet.playTogether(animator2, animator3)
            animatorSet.start()
        }
    }

}
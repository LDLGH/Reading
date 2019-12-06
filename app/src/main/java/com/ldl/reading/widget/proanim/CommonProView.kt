package com.ldl.reading.widget.proanim

import android.animation.Animator
import android.content.Context
import android.graphics.Camera
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import com.ldl.reading.R

/**
 * 作者：LDL 创建时间：2019/12/4
 * 类说明：
 */
class CommonProView constructor(
    context: Context,
    attrs: AttributeSet? = null
) : RelativeLayout(context, attrs) {

    private val camera = Camera()

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        val imageView = findViewById<ImageView>(R.id.imageView)
        val button = findViewById<Button>(R.id.Translation)
        button.setOnClickListener {
            imageView.animate()
                .translationX(500f)
                .translationY(200f)
                .translationZ(100f)
                .rotation(360f)
                .alpha(0.5f)
                .scaleX(0.5f)
                .scaleY(0.5f)
                .duration = 2000
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

}
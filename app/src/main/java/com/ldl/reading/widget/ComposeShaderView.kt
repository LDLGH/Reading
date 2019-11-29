package com.ldl.reading.widget

import android.content.Context
import android.graphics.*
import android.graphics.ComposeShader
import android.util.AttributeSet
import android.view.View
import com.ldl.reading.R

/**
 * 作者：LDL 创建时间：2019/11/29
 * 类说明：
 */
class ComposeShaderView constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        val bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.batman)
        val bitmap2 = BitmapFactory.decodeResource(context.resources, R.drawable.batman_logo)
        val shader1 = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        val shader2 = BitmapShader(bitmap2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        val shader = ComposeShader(shader1, shader2, PorterDuff.Mode.XOR)
        mPaint.shader = shader
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val size = getSize(widthMeasureSpec)
        setMeasuredDimension(size, size)
    }

    private fun getSize(size: Int): Int {
        var default = 100
        val mode = MeasureSpec.getMode(size)
        if (mode != MeasureSpec.UNSPECIFIED) {
            default = MeasureSpec.getSize(size)
        }
        return default
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawCircle(500f, 500f, 400f, mPaint)
    }
}
package com.ldl.reading.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.ldl.reading.R

/**
 * 作者：LDL 创建时间：2019/10/12
 * 类说明：
 */
class CustomView constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private var paint: Paint = Paint()

    private var defaultSize: Int = 100

    init {
        //第二个参数就是我们在styles.xml文件中的<declare-styleable>标签
        //即属性集合的标签，在R文件中名称为R.styleable+name
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomView)

        //第一个参数为属性集合里面的属性，R文件名称：R.styleable+属性集合名称+下划线+属性名称
        //第二个参数为，如果没有设置这个属性，则设置的默认的值
        defaultSize = typedArray.getDimensionPixelSize(R.styleable.CustomView_default_size, 100)

        //最后记得将TypedArray对象回收
        typedArray.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        var width = getMySize(widthMeasureSpec)
        var height = getMySize(heightMeasureSpec)
        if (height > width) {
            height = width
        } else {
            width = height
        }
        setMeasuredDimension(width, height)
    }

    private fun getMySize(measureSpec: Int): Int {
        val mode = MeasureSpec.getMode(measureSpec)
        val size: Int
        size = if (mode == MeasureSpec.UNSPECIFIED) {
            100
        } else {
            defaultSize
        }
        return size
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.color = ContextCompat.getColor(context, R.color.colorAccent)
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 10F
        paint.isAntiAlias = true
        val r = measuredWidth / 2
        canvas?.drawCircle(r.toFloat(), r.toFloat(), r.toFloat(), paint)
    }
}
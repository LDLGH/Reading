package com.ldl.reading.widget

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup

/**
 * 作者：LDL 创建时间：2019/11/26
 * 类说明：
 */
class MyViewGroup constructor(
    context: Context,
    attrs: AttributeSet? = null
) : ViewGroup(context, attrs) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        //将所有的子View进行测量，这会触发每个子View的onMeasure函数
        //注意要与measureChild区分，measureChild是对单个view进行测量
        measureChildren(widthMeasureSpec, heightMeasureSpec)

        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        if (childCount == 0) {//如果没有子View,当前ViewGroup没有存在的意义，不用占用空间
            setMeasuredDimension(0, 0)
        } else {
            //如果宽高都是包裹内容
            if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
                //我们将高度设置为所有子View的高度相加，宽度设为子View中最大的宽度
                setMeasuredDimension(getMaxChildWidth(), getTotalHeight())
            } else if (heightMode == MeasureSpec.AT_MOST) {//如果只有高度是包裹内容
                //宽度设置为ViewGroup自己的测量宽度，高度设置为所有子View的高度总和
                setMeasuredDimension(widthSize, getTotalHeight())
            } else if (widthMode == MeasureSpec.AT_MOST) {//如果只有宽度是包裹内容
                //宽度设置为子View中宽度最大的值，高度设置为ViewGroup自己的测量值
                setMeasuredDimension(getMaxChildWidth(), heightSize)
            }
        }
    }

    /***
     * 获取子View中宽度最大的值
     */
    private fun getMaxChildWidth(): Int {
        var maxWidth = 0
        for (i in 0 until childCount) {
            val childAt = getChildAt(i)
            if (childAt.measuredWidth > maxWidth) {
                maxWidth = childAt.measuredWidth
            }
        }
        return maxWidth
    }

    /***
     * 将所有子View的高度相加
     **/
    private fun getTotalHeight(): Int {
        var height = 0
        for (i in 0 until childCount) {
            val childAt = getChildAt(i)
            height += childAt.measuredHeight
        }
        return height
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        var curHeight = 0
        for (i in 0 until childCount) {
            val childAt = getChildAt(i)
            val measuredWidth = childAt.measuredWidth
            val measuredHeight = childAt.measuredHeight
            childAt.layout(0, curHeight, measuredWidth, curHeight + measuredHeight)
            curHeight += measuredHeight
        }
    }
}
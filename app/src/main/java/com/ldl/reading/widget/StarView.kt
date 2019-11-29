package com.ldl.reading.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Point
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.ldl.reading.R
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

/**
 * 作者：LDL 创建时间：2019/11/28
 * 类说明：
 */
class StarView constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private var mPaint = Paint()
    private var mPath = Path()

    private var mPoints = ArrayList<Point>()

    private val points = IntArray(12)

    private val xA = 400
    private val yA = 200
    private val r = 200

    init {
        mPaint.color = ContextCompat.getColor(context, R.color.colorAccent)
        mPaint.style = Paint.Style.FILL
        initPoint()
        for (i in 0 until points.size-1){
            mPath.lineTo(points[i].toFloat(), points[i+1].toFloat())
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawPath(mPath, mPaint)
    }


    private fun initPoint() {
        val pA = Point()
        pA.x = xA
        pA.y = yA
        mPoints.add(pA)



        val pC = Point()
        val pD = Point()
        pC.x = (xA - r * sin(Math.toRadians(18.0))).toInt()
        pD.x = (xA + r * sin(Math.toRadians(18.0))).toInt()
        pC.y = (r * cos(Math.toRadians(18.0))).toInt()
        pD.y = pC.y
        mPoints.add(pC)
        mPoints.add(pD)

        val pB = Point()
        val pE = Point()
        pB.x = xA - xA / 2
        pE.x = xA + xA / 2
        pB.y = (yA + sqrt(
            ((pD.x - pC.x).toDouble()).pow(2.0) - (r / 2).toDouble().pow(2.0)
        )).toInt()
        pC.y = pB.y

        mPoints.add(pB)
        mPoints.add(pE)

        points[0] = xA
        points[1] = yA
        points[2] = pD.x
        points[3] = pD.y
        points[4] = pB.x
        points[5] = pB.y
        points[6] = pE.x
        points[7] = pE.y
        points[8] = pC.x
        points[9] = pC.y
        points[10] = xA
        points[11] = yA
    }


}
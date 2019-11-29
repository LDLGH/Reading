package com.ldl.reading.widget

import android.content.Context
import android.graphics.*
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.ldl.reading.R
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin


/**
 * 作者：LDL 创建时间：2019/11/27
 * 类说明：
 */
class ArcView constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    //内圆弧外轮廓矩形区域。
    private lateinit var mInnerOvalShape: RectF
    //外圆的外轮廓矩形区域。
    private lateinit var mOutterOvalShape: RectF

    //左上角的横坐标
    private var mCircleLeft = 100
    //左上角的纵坐标
    private var mCircleTop = 50
    //圆的半径
    private var mCircleRadius = 200
    //圆的各个角度的范围
    private val mCircleDegreeRange = intArrayOf(0, 2, 7, 7, 30, 129, 120, 58)

    //paints集合
    private val mPaints = ArrayList<Paint>()

    private val mPaintPurple = Paint(ANTI_ALIAS_FLAG)
    private val mPaintGray = Paint(ANTI_ALIAS_FLAG)
    private val mPaintGreen = Paint(ANTI_ALIAS_FLAG)
    private val mPaintBlue = Paint(ANTI_ALIAS_FLAG)
    private val mPaintRed = Paint(ANTI_ALIAS_FLAG)
    private val mPaintYellow = Paint(ANTI_ALIAS_FLAG)
    private val mPaint = Paint(ANTI_ALIAS_FLAG)

    //line
    private val mPaintPath = Paint(ANTI_ALIAS_FLAG)
    //text
    private val mPaintText = Paint(ANTI_ALIAS_FLAG)
    //paths集合
    private val mPaths = ArrayList<Path>()
    //points集合
    private val mPoints = ArrayList<Point>()

    private val mRect = Rect()

    //文本内容
    private val mStrings = arrayOf(
        "Froyo",
        "Gingerbread",
        "Ice Cream Sandwich",
        "Jelly Bean",
        "KitKat",
        "Lollipop",
        "Marshmallow"
    )

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawColor(ContextCompat.getColor(context, R.color.colorPrimary))
        initCircle()
        drawPie(canvas)
        initLineAndText()
        drawLineAndText(canvas)
    }

    private fun initCircle() {
        //内圆，左上角坐标（100,50），右下角（500,450），圆半径为200
        mInnerOvalShape = RectF(100f, 50f, 500f, 450f)
        //外圆，左上角坐标（90,40），右下角（490,440），圆半径为200
        mOutterOvalShape = RectF(90f, 40f, 490f, 440f)
        mPaints.clear()
        mPaths.clear()
        //设置paint的颜色
        mPaints.add(mPaint)
        mPaintPurple.color = Color.argb(190, 115, 15, 189)
        mPaints.add(mPaintPurple)
        mPaintGray.color = Color.argb(190, 144, 138, 143)
        mPaints.add(mPaintGray)
        mPaintGreen.color = Color.argb(190, 138, 216, 91)
        mPaints.add(mPaintGreen)
        mPaintBlue.color = Color.argb(190, 97, 176, 237)
        mPaints.add(mPaintBlue)
        mPaintRed.color = Color.argb(190, 216, 44, 37)
        mPaints.add(mPaintRed)
        mPaintYellow.color = Color.argb(190, 228, 227, 17)
        mPaints.add(mPaintYellow)
    }

    private fun drawPie(canvas: Canvas?) {
        var start = 0
        for (i in 0 until mPaints.size) {
            if (i == 5) {
                canvas?.drawArc(
                    mOutterOvalShape, (start + mCircleDegreeRange[i]).toFloat(),
                    mCircleDegreeRange[i + 1].toFloat(), true, mPaints[i]
                )
                start += mCircleDegreeRange[i]
                continue
            }
            canvas?.drawArc(
                mInnerOvalShape, (start + mCircleDegreeRange[i]).toFloat(),
                mCircleDegreeRange[i + 1].toFloat(), true, mPaints[i]
            )
            start += mCircleDegreeRange[i]
        }
    }

    private fun getPoint(degree: Int): Point {
        val point = Point()
        point.x = (mCircleLeft + mCircleRadius + mCircleRadius * cos(degree * PI / 180)).toInt()
        point.y = (mCircleTop + mCircleRadius + mCircleRadius * sin((degree * PI / 180))).toInt()
        return point
    }

    private fun initLineAndText() {
        mPaintPath.color = Color.argb(120, 232, 232, 232)
        mPaintPath.style = Paint.Style.STROKE
        mPaintPath.strokeWidth = 4f

        mPaintText.color = Color.WHITE
        mPaintText.textSize = 15f

        //获取7块区域的角度
        val degree = IntArray(7)
        var start = 0
        for (i in 0 until 7) {
            start += mCircleDegreeRange[i]
            degree[i] = start + (mCircleDegreeRange[i + 1]) / 2
        }
        //7条划线的路径（path）及point的坐标
        var left = 0
        for (i in 0 until 7) {
            val path = Path()
            val p = getPoint(degree[i])
            path.moveTo(p.x.toFloat(), p.y.toFloat())
            when (i) {
                0 -> {
                    path.lineTo(p.x + 70f, p.y.toFloat())
                    p.x += 70
                    left = p.x
                }
                1, 2 -> {
                    path.lineTo(p.x + 25f, p.y.toFloat())
                    path.rLineTo(20f, 20f)
                    path.rLineTo(25f, 0f)
                    p.x = left
                    p.y += 20
                }
                3 -> {
                    path.lineTo(p.x + 25f, p.y + 25f)
                    path.rLineTo(70f, 0f)
                    p.x = left
                    p.y += 25
                }
                4 -> {
                    path.lineTo(p.x - 25f, p.y + 25f)
                    path.rLineTo(-70f, 0f)
                    p.x -= 95
                    p.y += 25
                }
                5 -> {
                    path.moveTo(p.x - 10f, p.y - 10f)
                    path.lineTo(p.x - 25f, p.y - 25f)
                    path.rLineTo(-70f, 0f)
                    p.x -= 95
                    p.y -= 25
                }
                6 -> {
                    path.lineTo(p.x + 25f, p.y - 25f)
                    path.rLineTo(70f, 0f)
                    p.x += 95
                    p.y -= 25
                }
                else -> {
                }
            }
            mPaths.add(path)
            mPoints.add(p)
        }
    }

    private fun drawLineAndText(canvas: Canvas?) {
        for (i in 0 until mPaths.size) {
            canvas?.drawPath(mPaths[i], mPaintPath)

            if (i == 4 || i == 5) {
                mPaintText.getTextBounds(mStrings[i], 0, mStrings[i].length, mRect)
                canvas?.drawText(
                    mStrings[i],
                    mPoints[i].x - mRect.width() - 5f,
                    mPoints[i].y.toFloat(),
                    mPaintText
                )
                continue
            }
            canvas?.drawText(
                mStrings[i],
                mPoints[i].x.toFloat(),
                mPoints[i].y.toFloat(),
                mPaintText
            )
        }

    }

}
package com.example.drawtutorial.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View


class CircleView(context: Context, attr: AttributeSet) : View(context, attr) {
    //  private val path = Path()
    private val paintFilled = Paint()
    private val paintNotFilled = Paint()
    private val oval = RectF()
     var fillPercent = 50
    private val sweepFilled: Shader by lazy {
        SweepGradient(0F, (measuredHeight / 2).toFloat(), Color.GREEN, Color.WHITE)


    }

    private val sweepNonFilled: Shader by lazy {
        SweepGradient(0F, (measuredHeight / 2).toFloat(), Color.GRAY, Color.WHITE)


    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)



        val radius = (height)-20
        val centerX = width / 2
        val centerY = 0
        // path.addCircle((centerX).toFloat(), (centerY).toFloat(), radius.toFloat(), Path.Direction.CCW)
        paintFilled.run {
            color = Color.GREEN
            strokeWidth = 30F
            style = Paint.Style.STROKE
            isAntiAlias = true
            strokeCap= Paint.Cap.BUTT
            //   shader=sweepFilled

        }

        paintNotFilled.run {
            color = Color.GRAY
            strokeWidth = 30F
            style = Paint.Style.STROKE
            isAntiAlias = true
            strokeCap= Paint.Cap.BUTT
            //   shader=sweepNonFilled

        }
        oval.set(
            (centerX - radius).toFloat(),
            centerY.toFloat(),
            (centerX + radius).toFloat(),
            ((centerY + radius).toFloat())
        )

        val startAngle1=51F
        val sweepAngle1=(78F*(100-fillPercent))/100
        val startAngle2= startAngle1+sweepAngle1
        val sweepAngle2=(78F*fillPercent)/100

        canvas.drawArc(oval, startAngle1, sweepAngle1, false, paintNotFilled)
        canvas.drawArc(oval, startAngle2, sweepAngle2, false, paintFilled)


    }


}
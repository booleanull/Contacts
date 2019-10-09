package com.booleanull.featurecontacts.utils

import android.graphics.Canvas
import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView

class RecyclerDivider(color: Int) : RecyclerView.ItemDecoration() {

    private val lineHeight = 2f
    private val paint = Paint()

    init {
        paint.color = color
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        c.save()

        for (i in 0 until parent.childCount - 1) {
            val child = parent.getChildAt(i)
            val width = child.measuredWidth.toFloat()
            val height = child.y + child.measuredHeight - lineHeight
            c.drawRect(0f, height, width, height + lineHeight, paint)
        }

        c.restore()
    }
}
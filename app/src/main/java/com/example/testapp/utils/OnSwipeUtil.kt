package com.example.testapp.utils

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView


abstract class SwipeToDeleteCallback :
    ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
    private val deleteColor = Color.parseColor("#f44336")
//    private val saveColor = Color.parseColor("#008000")

    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        if (viewHolder.adapterPosition == 10) return 0
        return super.getMovementFlags(recyclerView, viewHolder)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
            val background = ColorDrawable(deleteColor)
            val itemView = viewHolder.itemView
//            when {
//                dX > 0 -> {
//                    background = ColorDrawable(saveColor)
//                    background.setBounds(itemView.left, itemView.top, (itemView.left + dX).toInt(), itemView.bottom)
//                }
//                dX < 0 -> {
//                    background = ColorDrawable(deleteColor)
            background.setBounds(itemView.left, itemView.top, itemView.right, itemView.bottom)
//                }
//                else -> {
//                    background = ColorDrawable(Color.TRANSPARENT)
//                }
//            }
            background.draw(c)
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
        }
    }

}
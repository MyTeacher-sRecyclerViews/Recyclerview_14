package com.example.recyclerview_swipe_14

interface ItemTouchHelperAdapter {
    fun onItemMove(fromPos: Int, toPos: Int)
    fun onItemDismiss(pos: Int
    )
}
package com.example.recyclerview_swipe_14

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class CustomAdapter(val users: ArrayList<User>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(),
    ItemTouchHelperAdapter {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = users[position]

        if (holder is CustomViewHolder) {
            holder.firstName.text = user.firstName
            holder.lastName.text = user.lastName
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val firstName: TextView = itemView.findViewById(R.id.firs_text)
        val lastName: TextView = itemView.findViewById(R.id.second_text)
    }

    override fun onItemDismiss(pos: Int) {
        users.removeAt(pos)
        notifyItemChanged(pos)
    }

    override fun onItemMove(fromPos: Int, toPos: Int) {
        if (fromPos < toPos) {
            for (i in fromPos until toPos) {
                Collections.swap(users, i, i + 1)
            }
        } else {
            for (i in fromPos downTo toPos + 1) {
                Collections.swap(users, i, i - 1)
            }
        }

        notifyItemMoved(fromPos, toPos)
    }
}
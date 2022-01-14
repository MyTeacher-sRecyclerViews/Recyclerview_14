package com.example.recyclerview_swipe_14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        val users = addedUserList()
        refreshAdapter(users)

    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = GridLayoutManager(this, 1)
    }

    private fun refreshAdapter(users: ArrayList<User>) {
        val adapter = CustomAdapter(users)
        recyclerView.adapter = adapter

        val callBack = SimpleItemTouchAdapter(adapter)
        val touchHelpers = ItemTouchHelper(callBack)
        touchHelpers.attachToRecyclerView(recyclerView)
    }

    private fun addedUserList(): ArrayList<User> {
        val users = ArrayList<User>()

        for (i in 0..30) {
            users.add(User("Android", "$i"))
        }
        return users
    }
}














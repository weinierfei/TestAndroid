package com.example.testandroid

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout

/**
 * Description:
 * @author: guoyongping
 * @date:  2021/12/19 10:43
 */
class CoorToolbarActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coor_toolbar)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        toolbar.title = ""
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }


        initRecyclerView()
    }
    private fun initRecyclerView() {
        val list = arrayListOf<String>()
        for (i in 0..30) {
            list.add("$i")
        }
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val coordinatorAdapter = CoordinatorAdapter()
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@CoorToolbarActivity)
            adapter = coordinatorAdapter

        }
        coordinatorAdapter.setList(list)
    }

}
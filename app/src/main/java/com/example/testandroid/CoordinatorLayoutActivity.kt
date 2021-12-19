package com.example.testandroid

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout

/**
 * Description:
 * @author: guoyongping
 * @date:  2021/12/18 11:34
 */
class CoordinatorLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coordinator_layout)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        val collapsingToolbarLayout = findViewById<CollapsingToolbarLayout>(R.id.collapsing_toolbar)
        val appbar = findViewById<AppBarLayout>(R.id.appbar)
        appbar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            Log.i("---->","$verticalOffset")
            if (verticalOffset > -400){
                collapsingToolbarLayout.title = "卒中患者康复服务"
            }else{
                collapsingToolbarLayout.title = ""
                toolbar.title = "卒中患者康复服务"
            }
        })

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
            layoutManager = LinearLayoutManager(this@CoordinatorLayoutActivity)
            adapter = coordinatorAdapter

        }
        coordinatorAdapter.setList(list)
    }

}
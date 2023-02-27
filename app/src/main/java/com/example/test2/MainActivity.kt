package com.example.test2

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test2.adapter.AlphaAdapter
import com.example.test2.databinding.ActivityMainBinding
import com.example.test2.model.AlphaCard

class MainActivity : AppCompatActivity() {

    private var recyclerView:RecyclerView? = null
    private var gridLayoutManager:GridLayoutManager? = null
    private var arrayList:List<AlphaCard> = ArrayList()
    private var alphaAdapter:AlphaAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.list)
        gridLayoutManager = GridLayoutManager(applicationContext,3,LinearLayoutManager.VERTICAL,false)

        arrayList = getData()
        alphaAdapter = AlphaAdapter(applicationContext, arrayList)

        //recyclerView?.setHasFixedSize(true)
        recyclerView?.adapter = alphaAdapter
        recyclerView?.layoutManager = gridLayoutManager
    }
    override fun onStart(){
        super.onStart()
        alphaAdapter?.submitList(getData())
    }
    private fun getData() = listOf(AlphaCard(R.drawable.ic_launcher_background,"First item"),
        AlphaCard(R.drawable.ic_launcher_background,"Second item"),
        AlphaCard(R.drawable.ic_launcher_foreground,"Third item"),
        AlphaCard(androidx.appcompat.R.drawable.abc_ab_share_pack_mtrl_alpha,"Fourth item"))
}
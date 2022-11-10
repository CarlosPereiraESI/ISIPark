package com.example.isipark

import MySimpleArrayAdapterObjects
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import sector

class DashboardActivity : AppCompatActivity() {

    val listView: ListView by lazy{
        findViewById<ListView>(R.id.dashboard_list_sectors)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)


        val codeBtn = findViewById<Button>(R.id.dashboard_code_btn)

        codeBtn.setOnClickListener {
            val intent = Intent(this@DashboardActivity, CodeActivity::class.java)
            startActivity(intent)
        }

        val values = mutableListOf<sector>(sector("Sector T", "Normal: 50", "Eletric: 3", "Motorcycle: 10", "R.Mobility: 1"), sector("Sector D", "Normal: 20", "Eletric: 1", "Motorcycle: 5", "R.Mobility: 0"), sector("Sector G", "Normal: 10", "Eletric: 0", "Motorcycle: 1", "R.Mobility: 2"))
        //var adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, values)
        var adapter = MySimpleArrayAdapterObjects(this, R.layout.layout_sector_dash , values)
        listView.adapter = adapter
    }
}
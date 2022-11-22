package com.example.isipark

import MySimpleArrayAdapterObjects
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ListView
import androidx.annotation.RequiresApi
import sector

class DashboardActivity : AppCompatActivity() {

    val listView: ListView by lazy{
        findViewById<ListView>(R.id.dashboard_list_sectors)
    }


    val valuesN = mutableListOf<sector>(sector("Sector T", "Normal: 50", "", "", ""), sector("Sector D", "Normal: 20", "", "", ""), sector("Sector G", "Normal: 10", "", "", ""))
    val valuesM = mutableListOf<sector>(sector("Sector T", "Normal: 50", "", "Motorcycle: 10", ""), sector("Sector D", "Normal: 20", "", "Motorcycle: 5", ""), sector("Sector G", "Normal: 10", "", "Motorcycle: 1", ""))
    val valuesE = mutableListOf<sector>(sector("Sector T", "Normal: 50", "Eletric: 3", "", ""), sector("Sector D", "Normal: 20", "Eletric: 1", "", ""), sector("Sector G", "Normal: 10", "Eletric: 0", "", ""))
    val valuesR = mutableListOf<sector>(sector("Sector T", "Normal: 50", "Eletric: 3", "", "R.Mobility: 1"), sector("Sector D", "Normal: 20", "Eletric: 1", "", "R.Mobility: 0"), sector("Sector G", "Normal: 10", "Eletric: 0", "", "R.Mobility: 2"))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)


        val codeBtn = findViewById<Button>(R.id.dashboard_code_btn)

        // Vehicle buttons
        val normalBtn = findViewById<ImageButton>(R.id.normal)
        val motoBtn = findViewById<ImageButton>(R.id.moto)
        val eletricBtn = findViewById<ImageButton>(R.id.eletric)
        val rmobBtn = findViewById<ImageButton>(R.id.rmob)


        normalBtn.setOnClickListener{
            var adapter = MySimpleArrayAdapterObjects(this, R.layout.layout_sector_dash , valuesN)
            listView.adapter = adapter
        }
        motoBtn.setOnClickListener{
            var adapter = MySimpleArrayAdapterObjects(this, R.layout.layout_sector_dash , valuesM)
            listView.adapter = adapter
        }
        eletricBtn.setOnClickListener{
            var adapter = MySimpleArrayAdapterObjects(this, R.layout.layout_sector_dash , valuesE)
            listView.adapter = adapter
        }
        rmobBtn.setOnClickListener{
            var adapter = MySimpleArrayAdapterObjects(this, R.layout.layout_sector_dash , valuesR)
            listView.adapter = adapter
        }

        codeBtn.setOnClickListener {
            val intent = Intent(this@DashboardActivity, CodeActivity::class.java)
            startActivity(intent)
        }


    }
}
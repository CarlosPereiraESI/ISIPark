package com.example.isipark

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CodeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code)

        val backBtn = findViewById<Button>(R.id.code_back_btn)


        backBtn.setOnClickListener {
            val intent = Intent(this@CodeActivity, DashboardActivity::class.java)
            startActivity(intent)
        }

        //PARA APAGAR SO PARA TESTAR
        val teste = findViewById<Button>(R.id.exp)

        teste.setOnClickListener {
            val intent = Intent(this@CodeActivity, Add_VehicleActivity::class.java)
            startActivity(intent)

        }



    }

    override fun onBackPressed() {}
}
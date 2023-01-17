package com.example.isipark.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.isipark.R

class SearchUsersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_users)

        val searchBtn = findViewById<Button>(R.id.search_btn)

        val back = findViewById<Button>(R.id.search_users_back_btn)
        val nameReg = findViewById<EditText>(R.id.fill_user_regist)

        //Go back to more options menu
        back.setOnClickListener {
            val intent = Intent(this@SearchUsersActivity,
                MoreOptionsActivity::class.java)
            startActivity(intent)
        }

        //Fill Missing
        searchBtn.setOnClickListener {

            }
        }
        // Falta o adapter

    override fun onBackPressed() {}
}
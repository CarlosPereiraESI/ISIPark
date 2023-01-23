package com.example.isipark.controller

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import com.example.isipark.R
import com.example.isipark.model.InterfacesRetroFit.Utils
import com.example.isipark.model.RetroFit.RetroReport
import com.example.isipark.model.RetroFit.RetroUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchUsersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_users)

        val searchBtn = findViewById<Button>(R.id.search_btn)

        val back = findViewById<Button>(R.id.search_users_back_btn)
        val nameReg = findViewById<EditText>(R.id.fill_user_regist)
        val listView = findViewById<ListView>(R.id.search_users_listview)

        //Get id and token of this user
        val sp = getSharedPreferences(this@SearchUsersActivity)
        val token = sp.getString("tokenA", null)

        //Show all users
        Utils.instance.getAllUser("Bearer $token")
            .enqueue(object : Callback<List<RetroUser>> {
                override fun onResponse(
                    call: Call<List<RetroUser>>,
                    response: Response<List<RetroUser>>
                ) {
                    if (response.code() == 200) {
                        val retroFit2 = response.body()
                        var adapter = retroFit2?.let {
                            SearchUserAdapter(this@SearchUsersActivity, it)
                        }
                        listView.adapter = adapter
                    }
                }

                override fun onFailure(call: Call<List<RetroUser>>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                }
            })

        //Introduce the user who has the same name as the searched
        searchBtn.setOnClickListener {
            if (nameReg.text.toString() == "") {
                Toast.makeText(this, "You need to put any name!", Toast.LENGTH_SHORT).show()
            } else {
                var nome = nameReg.text.toString()
                Utils.instance.getUserByName(nome, "Bearer $token")
                    .enqueue(object : Callback<List<RetroUser>> {
                        override fun onResponse(
                            call: Call<List<RetroUser>>,
                            response: Response<List<RetroUser>>
                        ) {
                            if (response.code() == 200) {
                                val retroFit2 = response.body()
                                var adapter = retroFit2?.let {
                                    SearchUserAdapter(this@SearchUsersActivity, it)
                                }
                                listView.adapter = adapter
                            }
                        }

                        override fun onFailure(call: Call<List<RetroUser>>, t: Throwable) {
                            Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                        }
                    })
            }
        }

        //Go back to more options menu
        back.setOnClickListener {
            val intent = Intent(
                this@SearchUsersActivity,
                MoreOptionsActivity::class.java
            )
            startActivity(intent)
        }
    }

    //Don't go back without click on back button
    override fun onBackPressed() {}

    // Function to get token and id
    fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(context.resources.getString(R.string.app_name),
            Context.MODE_PRIVATE)
    }
}
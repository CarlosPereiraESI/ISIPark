package com.example.isipark.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.isipark.R
import com.example.isipark.model.InterfacesRetroFit.Utils
import com.example.isipark.model.RetroFit.RetroPersonData
import com.example.isipark.model.RetroFit.RetroReport
import com.example.isipark.model.RetroFit.RetroUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val retroUser = RetroUser(id=0, name="", nif=0, birthDate="",
            gender="", typeUserID = 0, addressID = 0, email="", password="",
            passwordH = "", passwordS ="", tok="")

        val createBtn = findViewById<Button>(R.id.register_create_btn)
        val email = findViewById<EditText>(R.id.register_email_et)
        val password = findViewById<EditText>(R.id.register_password_et)
        val confpassword = findViewById<EditText>(R.id.register_conf_password_et)
        val back = findViewById<Button>(R.id.back_register_btn)

        //Back button, go to login page
        back.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        //Make a register
        createBtn.setOnClickListener {
            if ( email.text.toString() == "" || password.text.toString() == "" ||
                confpassword.text.toString() == ""){
                Toast.makeText(this,"It has empty fields!", Toast.LENGTH_SHORT).show()
            }
            else{
                if(password.text.toString() == confpassword.text.toString()){
                    if (isCorrect(email.text.toString()) == true){
                        Utils.instance.getDataByEmail(email.text.toString())
                            .enqueue(object : Callback<RetroPersonData> {
                                override fun onResponse(call: Call<RetroPersonData>,
                                                        response: Response<RetroPersonData>) {
                                    if (response.code() == 200) {
                                        val responseBody = response.body()
                                        retroUser.id = responseBody!!.userID
                                        retroUser.name = responseBody.name
                                        retroUser.email = email.text.toString()
                                        retroUser.typeUserID = 1
                                        retroUser.addressID = 1
                                        retroUser.nif = responseBody.nif
                                        retroUser.password = confpassword.text.toString()
                                        retroUser.birthDate = responseBody.birthDate
                                        retroUser.gender = responseBody.gender

                                        Utils.instance.insertUser(retroUser)
                                            .enqueue(object: Callback<Boolean> {
                                                override fun onResponse(call: Call<Boolean>,
                                                                        response:
                                                                        Response<Boolean>) {
                                                    if(response.code() == 200) {
                                                        Toast.makeText(
                                                            this@RegisterActivity,
                                                            "Created!",
                                                            Toast.LENGTH_LONG
                                                        ).show()

                                                        val intent = Intent(
                                                            this@RegisterActivity,
                                                            DashboardActivity::class.java)
                                                        startActivity(intent)
                                                    }
                                                }
                                                override fun onFailure(call: Call<Boolean>,
                                                                       t: Throwable) {
                                                    Toast.makeText(
                                                        applicationContext, t.message,
                                                        Toast.LENGTH_LONG
                                                    ).show()
                                                }
                                            })
                                    }
                                }
                                override fun onFailure(call: Call<RetroPersonData>, t: Throwable) {
                                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG)
                                        .show()
                                }
                            })

                        val intent = Intent(this@RegisterActivity,
                            LoginActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this,"Invalid E-mail, try again!",
                            Toast.LENGTH_SHORT).show()
                    }
                }
                else {
                    Toast.makeText(this, "The passwords don't match!",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    // Function to validate an email
    private fun isCorrect(string: String): Boolean {
        return string.matches("(([a-zA-Z0-9.])+[@](alunos.)?ipca.pt)".toRegex())
    }

    //Don't go back without click on back button
    override fun onBackPressed() {}
}
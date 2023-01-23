package com.example.isipark.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.isipark.R
import com.example.isipark.model.InterfacesRetroFit.Utils
import com.example.isipark.model.RetroFit.RetroReport
import com.example.isipark.model.RetroFit.RetroUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var retroUser = RetroUser(id=0, name="", nif=0, birthDate="",
            gender="", typeUserID = 0, addressID = 0, email="", password="")

        val createBtn = findViewById<Button>(R.id.register_create_btn)
        val email = findViewById<EditText>(R.id.register_email_et)
        val password = findViewById<EditText>(R.id.register_password_et)
        val confpassword = findViewById<EditText>(R.id.register_conf_password_et)
        val back = findViewById<Button>(R.id.back_register_btn)

        back.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        createBtn.setOnClickListener {
            if ( email.text.toString() == "" || password.text.toString() == "" ||
                confpassword.text.toString() == ""){
                Toast.makeText(this,"It has empty fields!", Toast.LENGTH_SHORT).show()
            }
            else{

                retroUser.id = 0
                retroUser.name=""
                retroUser.nif = 123456788
                retroUser.birthDate = ""
                retroUser.gender = ""
                retroUser.typeUserID = 1
                retroUser.addressID = 1
                retroUser.email = email.text.toString()
                retroUser.password = confpassword.text.toString()

                if(password.text.toString() == confpassword.text.toString()){
                    if (isCorrect(email.text.toString()) == true){
                        Utils.instance.insertUser(retroUser)
                            .enqueue(object : Callback<Boolean> {
                                override fun onResponse(call: Call<Boolean>,
                                                        response: Response<Boolean>) {
                                    if (response.code() == 200) {
                                        Toast.makeText(this@RegisterActivity,
                                            "Created!", Toast.LENGTH_LONG).show()
                                        val intent = Intent(this@RegisterActivity,
                                            DashboardActivity::class.java)
                                        startActivity(intent)
                                    }
                                }
                                override fun onFailure(call: Call<Boolean>, t: Throwable) {
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
    private fun isCorrect(string: String): Boolean {
        return string.matches("(([a-zA-Z0-9.])+[@](alunos.)?ipca.pt)".toRegex())
    }
    override fun onBackPressed() {}
}
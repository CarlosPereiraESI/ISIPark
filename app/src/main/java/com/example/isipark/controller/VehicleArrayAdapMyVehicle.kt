package com.example.isipark.controller

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.isipark.R
import com.example.isipark.model.InterfacesRetroFit.Utils
import com.example.isipark.model.RetroFit.RetroPlaceFree

import com.example.isipark.model.RetroFit.RetroVehicleType
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VehicleArrayAdapMyVehicle (context: Context,
                                 list: List<RetroVehicleType>):
    ArrayAdapter<RetroVehicleType>(context, -1) {

    val mList : List<RetroVehicleType> = list

    override fun getItem(position: Int): RetroVehicleType? {
        return mList.get(position)
    }

    override fun getCount(): Int {
        return mList.count()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view = LayoutInflater.from(context).inflate(R.layout.layout_vehicles,parent, false)


        //layout_sector_dash
        val tipo = view.findViewById<TextView>(R.id.type_vehicles)
        val resgistration = view.findViewById<TextView>(R.id.registration_vehicles)

        val delete = view.findViewById<Button>(R.id.deleteVehicle)

        //para mandar para o layout
        val p = getItem(position)

        if (p != null) {
            resgistration.text = p.licensePlate.toString()
        }

        if (p != null) {
            tipo.text = p.description.toString()
        }
        val plate : String

        if (p != null) {
           plate = p.licensePlate.toString()
        }else{
            plate=""
        }

        //Go back to profile page
        delete.setOnClickListener {
            Utils.instance.deleteVehicle(plate)
                .enqueue(object: Callback<String> {
                    override fun onResponse(call: Call<String>,
                                            response: Response<String>
                    ) {
                        if(response.code() == 200) {
                            val responseBody = response.body()

                            //falta fazer o refresh a activity OU enviar mensagem
                            println("AQUI-------------------------------")
                            println(responseBody)

                        }else{
                            val responseBody = response.body()
                            println("diferente de 200 ok  -----------------------------")
                            println(responseBody)
                        }
                    }
                    override fun onFailure(call: Call<String>, t: Throwable) {

                    }
                })

        }

        //deleteVehicle

        return view
    }



}
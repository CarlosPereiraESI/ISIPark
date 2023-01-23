package com.example.isipark.controller

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.isipark.R
import com.example.isipark.model.InterfacesRetroFit.Utils
import com.example.isipark.model.RetroFit.RetroSetor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ParkingEditArrayAdapter(context: Context, list: List<RetroSetor>):
    ArrayAdapter<RetroSetor>(context, -1) {

    private var token: SharedPreferences? = null

    val mList : List<RetroSetor> = list

    override fun getItem(position: Int): RetroSetor? {
        return mList.get(position)
    }

    override fun getCount(): Int {
        return mList.count()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view = LayoutInflater.from(context).inflate(R.layout.layout_parking_edit,
            parent, false)

        //layout parking edit
        val sector = view.findViewById<TextView>(R.id.sector)
        val delete = view.findViewById<ImageView>(R.id.logo_cross)

        //para mandar para o layout
        val p = getItem(position)

        val idP = p?.id
        if (p != null) {
            sector.text = "Sector: ${p.sectorName}"
        }
        delete.setOnClickListener {
            Utils.instance.deleteSector(idP!!)
                .enqueue(object: Callback<String> {
                    override fun onResponse(call: Call<String>,
                                            response: Response<String>) {
                    }
                    override fun onFailure(call: Call<String>, t: Throwable) {
                    }
                })
            Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show()
        }
        return view
    }
}

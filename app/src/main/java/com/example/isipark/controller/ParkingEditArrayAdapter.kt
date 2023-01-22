package com.example.isipark.controller

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.core.graphics.convertTo
import com.example.isipark.R
import com.example.isipark.model.RetroFit.RetroAdminMessage
import com.example.isipark.model.RetroFit.RetroReport
import com.example.isipark.model.RetroFit.RetroSetor


class ParkingEditArrayAdapter(context: Context, list: List<RetroSetor>):
    ArrayAdapter<RetroSetor>(context, -1) {

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
        //para mandar para o layout
        val p = getItem(position)

        if (p != null) {
            sector.text = "Sector: ${p.sectorName}"
        }
        return view
    }
}
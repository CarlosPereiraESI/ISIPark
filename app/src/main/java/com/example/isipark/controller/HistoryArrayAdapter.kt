package com.example.isipark.controller

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.isipark.R
import com.example.isipark.model.RetroFit.RetroAdminMessage
import com.example.isipark.model.RetroFit.RetroHistory

class HistoryArrayAdapter(context: Context, list: List<RetroHistory>):
    ArrayAdapter<RetroHistory>(context, -1) {

    val mList : List<RetroHistory> = list

    override fun getItem(position: Int): RetroHistory? {
        return mList.get(position)
    }

    override fun getCount(): Int {
        return mList.count()
    }

    @SuppressLint("MissingInflatedId")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view = LayoutInflater.from(context).inflate(R.layout.layout_history,
            parent, false)

        //layout_sector_dash
        val id_h = view.findViewById<TextView>(R.id.id_h)
        val entry = view.findViewById<TextView>(R.id.entry)
        val exit = view.findViewById<TextView>(R.id.exit)
        val numPlaces = view.findViewById<TextView>(R.id.numberplaces)

        //para mandar para o layout
        val p = getItem(position)

        if (p != null) {
            id_h.text = p.Id.toString()
        }

        if (p != null) {
            entry.text = p.entryTime
        }
        if (p != null) {
            exit.text = p.exitTime
        }

        if (p != null) {
            numPlaces.text = p.numberPlaces.toString()
        }
        return view
    }
}
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


class ReportsMessageAdapter(context: Context, list: List<RetroReport>):
    ArrayAdapter<RetroReport>(context, -1) {

    val mList : List<RetroReport> = list

    override fun getItem(position: Int): RetroReport? {
        return mList.get(position)
    }

    override fun getCount(): Int {
        return mList.count()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view = LayoutInflater.from(context).inflate(R.layout.layout_reports_messages,
            parent, false)

        //layout_sector_dash
        val name = view.findViewById<TextView>(R.id.name_report)
        val sector = view.findViewById<TextView>(R.id.sector_report)
        val registration = view.findViewById<TextView>(R.id.regist_report)
        val descricao = view.findViewById<TextView>(R.id.more_report)
        val data = view.findViewById<TextView>(R.id.data_report)

        //para mandar para o layout
        val p = getItem(position)

        if (p != null) {
            name.text = p.name
        }
        if (p != null) {
            sector.text = "Sector: ${p.sector}"
        }
        if (p != null) {
            registration.text ="Registration: ${p.licensePlate}"
        }
        if (p != null) {
            descricao.text = "Description: ${p.description}"
        }
        if (p != null) {
            data.text = p.date
        }


        return view
    }
}
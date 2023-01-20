package com.example.isipark.controller

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.isipark.R
import com.example.isipark.model.RetroFit.RetroAdminMessage

class NotificationAdminAdapter(context: Context, list: List<RetroAdminMessage>):
    ArrayAdapter<RetroAdminMessage>(context, -1) {

    val mList : List<RetroAdminMessage> = list

    override fun getItem(position: Int): RetroAdminMessage? {
        return mList.get(position)
    }

    override fun getCount(): Int {
        return mList.count()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view = LayoutInflater.from(context).inflate(R.layout.layout_reports,parent, false)

        //layout_sector_dash
        val name = view.findViewById<TextView>(R.id.titulo_report)
        val descricao = view.findViewById<TextView>(R.id.dados_report)
        val data = view.findViewById<TextView>(R.id.data_report)

        //para mandar para o layout
        val p = getItem(position)

        if (p != null) {
            name.text = p.name
        }
        if (p != null) {
            descricao.text = p.desc
        }

        if (p != null) {
            data.text = p.date
        }

        return view
    }
}
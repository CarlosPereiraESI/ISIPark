package com.example.isipark.controller

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.isipark.R
import com.example.isipark.model.RetroFit.RetroAdminMessage

class ReportArrayAdapter(context: Context, list: List<RetroAdminMessage>):
    ArrayAdapter<RetroAdminMessage>(context, -1) {

    val mList : List<RetroAdminMessage> = list

    override fun getItem(position: Int): RetroAdminMessage? {
        return mList.get(position)
    }

    override fun getCount(): Int {
        return mList.count()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view = LayoutInflater.from(context).inflate(R.layout.layout_notification,parent, false)

        //layout_sector_dash
        val idR = view.findViewById<TextView>(R.id.titulo_notifi)
        val descricao = view.findViewById<TextView>(R.id.mensagem_notifi)
        val data = view.findViewById<TextView>(R.id.data_notifi)

        //para mandar para o layout
        val p = getItem(position)

        if (p != null) {
            idR.text = p.idR.toString()
        }
        if (p != null) {
            descricao.text = p.desc
        }

        if (p != null) {
            descricao.text = p.date
        }


        return view
    }



}
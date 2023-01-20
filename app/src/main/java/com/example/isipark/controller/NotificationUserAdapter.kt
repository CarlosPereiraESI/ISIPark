package com.example.isipark.controller

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.isipark.R
import com.example.isipark.model.RetroFit.RetroUserMessageId

class NotificationUserAdapter(context: Context, list: List<RetroUserMessageId>):
    ArrayAdapter<RetroUserMessageId>(context, -1) {

    val mList : List<RetroUserMessageId> = list

    override fun getItem(position: Int): RetroUserMessageId? {
        return mList.get(position)
    }

    override fun getCount(): Int {
        return mList.count()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view = LayoutInflater.from(context).inflate(R.layout.layout_noticationuser,parent, false)

        //layout_sector_dash
        val data = view.findViewById<TextView>(R.id.data_notifiUser)
        val descricao = view.findViewById<TextView>(R.id.mensagem_notifiUser)


        //para mandar para o layout
        val p = getItem(position)

        if (p != null) {
            data.text = p.date.toString()
        }
        if (p != null) {
            descricao.text = p.description
        }

        return view
    }

}
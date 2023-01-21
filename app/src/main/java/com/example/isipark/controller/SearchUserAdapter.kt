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
import com.example.isipark.model.RetroFit.RetroUser


class SearchUserAdapter(context: Context, list: List<RetroUser>):
    ArrayAdapter<RetroUser>(context, -1) {

    val mList : List<RetroUser> = list

    override fun getItem(position: Int): RetroUser? {
        return mList.get(position)
    }

    override fun getCount(): Int {
        return mList.count()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view = LayoutInflater.from(context).inflate(R.layout.layout_search_users,parent, false)

        //layout_sector_dash
        val name = view.findViewById<TextView>(R.id.name_search_user)
        val nif = view.findViewById<TextView>(R.id.nif_search_user)
        val gender = view.findViewById<TextView>(R.id.genero_search_users)
        val userType = view.findViewById<TextView>(R.id.tipoUser_search_user)
        val email = view.findViewById<TextView>(R.id.email_search_user)

        //para mandar para o layout
        val p = getItem(position)

        if (p != null) {
            name.text = "${p.name} - ${p.id}"
        }
        if (p != null) {
            nif.text = "Nif: ${p.nif}"
        }
        if (p != null) {
            gender.text ="Gender: ${p.gender}"
        }
        if (p != null) {
            if (p.typeUserID == 1){
                userType.text = "Type: Student"
            }
            if (p.typeUserID == 2){
                userType.text = "Type: Teacher"
            }else {
                userType.text = "Type: Staff"
            }

        }
        if (p != null) {
            email.text = "Email: ${p.email}"
        }


        return view
    }
}
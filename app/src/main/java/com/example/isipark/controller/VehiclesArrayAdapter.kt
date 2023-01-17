package com.example.isipark.controller

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.isipark.R
import com.example.isipark.model.RetroFit.RetroPlaceFree

class VehiclesArrayAdapter(context: Context, list: List<RetroPlaceFree>):ArrayAdapter<RetroPlaceFree>(context, -1){

    val mList : List<RetroPlaceFree> = list

    override fun getItem(position: Int): RetroPlaceFree? {
        return mList.get(position)
    }

    override fun getCount(): Int {
        return mList.count()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view = LayoutInflater.from(context).inflate(R.layout.layout_sector_dash,parent, false)



        //layout_sector_dash
        val sector_name = view.findViewById<TextView>(R.id.sector_name)
        val normal = view.findViewById<TextView>(R.id.normal)
        val eletric = view.findViewById<TextView>(R.id.eletric)
        val motorcycle = view.findViewById<TextView>(R.id.motorcycle)
        val r_mob = view.findViewById<TextView>(R.id.reduce_mobility)

        //para mandar para o layout
        val p = getItem(position)

        if (p != null) {
            sector_name.text = p.setor
        }
        if (p != null) {
            normal.text = p.normal
        }

        if (p != null) {
            //eletric.text = p.eletric
            if(p.eletric == ""){
                eletric.visibility = View.GONE
            } else {
                eletric.text = p.eletric
            }
        }

        if (p != null) {
            if(p.motorcycle == ""){
                motorcycle.visibility = View.GONE
            } else {
                motorcycle.text = p.motorcycle
            }
        }

        if (p != null) {

            if(p.reduce_mob == ""){
                r_mob.visibility = View.GONE
            } else {
                r_mob.text = p.reduce_mob
            }
        }

        return view
    }

}
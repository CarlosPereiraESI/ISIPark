package com.example.isipark.controller

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.isipark.R
import com.example.isipark.model.sector

class VehiclesArrayAdapter(context: Context, resource: Int,
                           objects: MutableList<sector>): ArrayAdapter<sector>(context,
                                    resource, objects){

    var mContext: Context
    var mValues: MutableList<sector>
    var mResource: Int

    init {
        mContext = context
        mValues = objects
        mResource = resource
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater = LayoutInflater.from(mContext)
        val rowView = inflater.inflate(mResource, parent, false)

        val sector_name = rowView.findViewById<TextView>(R.id.sector_name)
        val normal = rowView.findViewById<TextView>(R.id.normal)
        val eletric = rowView.findViewById<TextView>(R.id.eletric)
        val motorcycle = rowView.findViewById<TextView>(R.id.motorcycle)
        val r_mob = rowView.findViewById<TextView>(R.id.reduce_mobility)

        val name = mValues[position].setor
        sector_name.text = name

        val norm = mValues[position].normal
        if(norm == ""){
            normal.visibility = View.GONE
        } else {
            normal.text = norm
        }

        val eletr = mValues[position].eletric
        if(eletr == ""){
            eletric.visibility = View.GONE
        } else {
            eletric.text = eletr
        }

        val motor = mValues[position].motorcycle
        if(motor == ""){
            motorcycle.visibility = View.GONE
        } else {
            motorcycle.text = motor
        }

        val rm = mValues[position].reduce_mob
        if(rm == ""){
            r_mob.visibility = View.GONE
        } else {
            r_mob.text = rm
        }
        return rowView
    }
}
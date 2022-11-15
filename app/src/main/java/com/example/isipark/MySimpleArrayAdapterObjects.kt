import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.isipark.R
import java.util.Objects
import sector


class MySimpleArrayAdapterObjects(context: Context, resource: Int, objects: MutableList<sector>): ArrayAdapter<sector>(context, resource, objects){

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

        val name = mValues[position].sector
        sector_name.text = name

        val norm = mValues[position].normal
        normal.text = norm

        val eletr = mValues[position].eletric
        eletric.text = eletr

        val motor = mValues[position].motorcycle
        motorcycle.text = motor

        val rm = mValues[position].r_mobility
        r_mob.text = rm

        return rowView

    }


}
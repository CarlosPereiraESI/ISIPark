package com.example.isipark.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
class Place(val id: Int, val placeTypeID: Int,
            val state: Boolean, val licensePlate: String) {
}*/

@Entity(tableName = "place")
data class Place(@PrimaryKey(autoGenerate = true)val id:Int=0,
                 val placeTypeID: Int?,
                 val state: Boolean?, val licensePlate: String?){

}
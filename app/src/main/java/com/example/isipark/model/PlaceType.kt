package com.example.isipark.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
class PlaceType(val id: Int, val description: String) {
}*/

@Entity(tableName = "placeType")
data class PlaceType(@PrimaryKey(autoGenerate = true)val id: Int=0,
                     val description: String?) {
}

package com.example.isipark.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
class Sector(val id: Int, val sectorName: String, val totalPlace: Int) {
}*/

@Entity(tableName = "setor")
data class Setor(@PrimaryKey(autoGenerate = true)val id: Int=0,
                 val sectorName: String?,
                 val totalPlace: Int?){

}
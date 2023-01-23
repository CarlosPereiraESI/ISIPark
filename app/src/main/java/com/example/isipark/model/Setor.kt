package com.example.isipark.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
class Sector(val id: Int, val sectorName: String, val totalPlace: Int) {
}*/

@Entity(tableName = "setor")
data class Setor(@PrimaryKey(autoGenerate = true) var id: Int=0,
                 var sectorName: String?,
                 var totalPlace: Int?){
}
package com.eyyuperdogan.room.model
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "car_table")
data class Car(
    @PrimaryKey(autoGenerate = true)
    val id:Int = Random().nextInt(1000),
    var title: String,
    var price: String
)
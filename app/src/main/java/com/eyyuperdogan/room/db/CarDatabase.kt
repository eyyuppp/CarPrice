package com.eyyuperdogan.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.eyyuperdogan.room.model.Car

@Database(entities = [Car::class], version = 1)
abstract class CarDatabase:RoomDatabase() {

    abstract fun carDao(): CarDao

}
package com.eyyuperdogan.room.model

import android.app.Application
import androidx.room.Room
import com.eyyuperdogan.room.db.CarDatabase

class App : Application(){
    override fun onCreate() {
        super.onCreate()
        carDatabase = Room.databaseBuilder(this.applicationContext, CarDatabase::class.java, "car_database").allowMainThreadQueries().build()
    }
    companion object{
        lateinit var carDatabase: CarDatabase
    }
}
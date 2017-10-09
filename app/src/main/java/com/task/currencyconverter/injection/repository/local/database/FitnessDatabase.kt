package com.ducere.fitnessband.repository.local.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.ducere.fitnessband.repository.local.dao.UserDao
import com.task.currencyconverter.injection.repository.local.entity.User

@Database(entities = arrayOf(User::class), version = 1)
abstract class FitnessDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}
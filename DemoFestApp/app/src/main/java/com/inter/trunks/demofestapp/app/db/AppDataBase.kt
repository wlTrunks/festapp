package com.inter.trunks.demofestapp.app.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.inter.trunks.demofestapp.registration.model.AppUser

@Database(
    version = 1
    , exportSchema = true,
    entities = arrayOf(AppUser::class)
)
abstract class AppDataBase : RoomDatabase() {
}
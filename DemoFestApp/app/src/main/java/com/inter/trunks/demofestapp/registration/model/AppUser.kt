package com.inter.trunks.demofestapp.registration.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "app_users")
data class AppUser(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "user_name")
    val name: String,
    @ColumnInfo(name = "user_password")
    val pass: String
)
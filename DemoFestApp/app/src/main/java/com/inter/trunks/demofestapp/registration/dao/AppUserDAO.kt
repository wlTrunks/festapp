package com.inter.trunks.demofestapp.registration.dao

import androidx.room.Query
import com.inter.trunks.demofestapp.base.dao.BaseDao
import com.inter.trunks.demofestapp.registration.model.AppUser

interface AppUserDAO : BaseDao<AppUser>{

    @Query("SELECT * FROM app_users WHERE user_name == :login")
    fun getUserbyName(login: String): AppUser
}
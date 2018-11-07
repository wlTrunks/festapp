package com.inter.trunks.demofestapp.base.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Update


/**
 * Базовый объект для работы с данными в БД
 */
@Dao
interface BaseDao<in T> {

    @Insert(onConflict = REPLACE)
    fun insert(vararg item: T)

    @Insert(onConflict = IGNORE)
    fun insertNoReplace(vararg item: T)

    @Update
    fun update(item: T)

    fun delete()

}
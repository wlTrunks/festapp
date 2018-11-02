package com.inter.trunks.demofestapp.registration.repository

interface RegInterefaceRepository {

    fun saveUser(login: String, pass: String):Int
}
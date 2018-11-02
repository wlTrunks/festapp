package com.inter.trunks.demofestapp.login.repository

interface LoginInterefaceRepository {
    /**
     * return Error code, после придумаю
     */
    fun singIn(login: String, pass: String): Int
}
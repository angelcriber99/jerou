package com.angel.zaml.models

class Geometry {

    private lateinit var lat: String
    private lateinit var long: String

    fun getLat(): String? {
        return lat
    }

    fun setLat(lat: String?) {
        this.lat = lat!!
    }

    fun getLong(): String? {
        return long
    }

    fun setLong(lat: String?) {
        this.long = lat!!
    }
}
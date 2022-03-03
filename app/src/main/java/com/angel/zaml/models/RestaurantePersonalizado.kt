package com.angel.zaml.models

import java.util.ArrayList

class RestaurantePersonalizado {
    
    private lateinit var title: String
    private var lng: Double = 0.0
    private var lat: Double = 0.0


    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String?) {
        this.title = title!!
    }

    fun getLng(): Double? {
        return lng
    }

    fun setLng(lng: Double) {
        this.lng = lng!!
    }

    fun getLat(): Double? {
        return lat
    }

    fun setLat(lat: Double) {
        this.lat = lat!!
    }
}
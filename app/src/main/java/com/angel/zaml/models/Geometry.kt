package com.angel.zaml.models

import com.google.type.LatLng
import java.math.BigDecimal
import java.util.ArrayList
import kotlin.properties.Delegates

class Geometry {
    private lateinit var coordinates: ArrayList<Double>

    fun getCoordinates(): ArrayList<Double>? {
        return coordinates
    }

    fun setCoordinates(coordinates: ArrayList<Double>) {
        this.coordinates = coordinates!!
    }
}


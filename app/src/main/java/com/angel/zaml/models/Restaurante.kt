package com.angel.zaml.models

import java.util.*

//http://www.zaragoza.es/sede/servicio/restaurante.jsonId?srsname=wgs84&fl=geometry,title,tel,email
//https://www.zaragoza.es/sede/servicio/monumento.json?fl=title,geometry&srsname=wsg84
class Restaurante {
    private lateinit var title: String
    private lateinit var geometry: Geometry

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String?) {
        this.title = title!!
    }

    fun getGeometry(): Geometry {
        return geometry
    }

    fun setGeometry(Geometry: Geometry?) {
        this.geometry = geometry!!
    }
}
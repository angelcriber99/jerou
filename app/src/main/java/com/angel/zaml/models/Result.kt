package com.angel.zaml.models

class Result {
    private lateinit var result : ArrayList<Restaurante>

    fun getResult(): ArrayList<Restaurante>? {
        return result
    }

    fun setResult(lat: String?) {
        this.result = result!!
    }
}
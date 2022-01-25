package com.angel.zaml.models

class Pokemon {
    private lateinit var id: String
    private lateinit var name: String
    private lateinit var number: Number

    fun getId() : String{
        return id
    }
    fun setId(new_id : String){
        id = new_id
    }
    fun getName() : String{
        return name
    }
    fun setName(new_name : String){
        name = new_name
    }
    fun getNumber() : Number {
        return number
    }
    fun setId(new_number : Number){
        number = new_number
    }



}
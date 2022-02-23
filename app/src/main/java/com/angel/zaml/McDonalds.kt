package com.angel.zaml

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.listener.CarouselListener
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class McDonalds : AppCompatActivity() {
    val list = mutableListOf<CarouselItem>()
    val list2 = mutableListOf<CarouselItem>()
    val list3 = mutableListOf<CarouselItem>()
    val list4 = mutableListOf<CarouselItem>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mc_donalds)


        // Carrousel 1
        //Find carrousel id
        val carrousel1: ImageCarousel = findViewById(R.id.carousel1)
        //Add content to the array
        list.add(CarouselItem(R.drawable.mcdonald_s_sandw, "Sandwiches"))
        list.add(CarouselItem(R.drawable.big_mac, " Sandwich BigMac"))
        list.add(CarouselItem(R.drawable.mc_royaledeluxe, "Sandwich Mc RoyalDeluxe"))
        list.add(CarouselItem(R.drawable.cuarto_libra, "Sandwich Cuarto de libra"))
        list.add(CarouselItem(R.drawable.mc_pollo, "Sandwich McPollo"))
        list.add(CarouselItem(R.drawable.cbo, "Sandwich CBO"))
        //Add photos to the carrousel
        carrousel1.addData(list)
        // Carousel listener
        carrousel1.carouselListener = object : CarouselListener {
            override fun onClick(position: Int, carouselItem: CarouselItem) {
                //https://youtu.be/ZnarHv_Jx-M?t=953
                Toast.makeText(this@McDonalds, "MCDONALDS: ${carouselItem.caption}", Toast.LENGTH_SHORT).show()
            }
            override fun onLongClick(position: Int, dataObject: CarouselItem) {
                // ...
            }
        }
        //Fin de Carrousel 1
        //-----------------------------------------------------------------------------------------------------------------------------
        //Carrousel 2
        //Find carrousel id
        val carrousel2: ImageCarousel = findViewById(R.id.carousel2)
        //Add content to the array
        list.add(CarouselItem(R.drawable.mc_american_style_chicken, "American Style Chicken"))
        list.add(CarouselItem(R.drawable.chicken_buffalo, "American_Style Chicken Buffalo"))
        list.add(CarouselItem(R.drawable.honey_mustard, "American Style Chicken honey_mustard"))
        //Add photos to the carrousel
        carrousel2.addData(list)
        // Carousel listener
        carrousel2.carouselListener = object : CarouselListener {
            override fun onClick(position: Int, carouselItem: CarouselItem) {
                //https://youtu.be/ZnarHv_Jx-M?t=953
                Toast.makeText(
                    this@McDonalds,
                    "MCDONALDS: ${carouselItem.caption}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onLongClick(position: Int, dataObject: CarouselItem) {
                // ...
            }
        }
        //Fin de Carrousel 2
        //------------------------------------------------------------------------------------------------------------------------------
        //Carrousel 3
        // Find carrousel id
        val carrousel3: ImageCarousel = findViewById(R.id.carousel3)
        //Add content to the array
        list.add(CarouselItem(R.drawable.gr_extreme, "Gran McExtreme de McDonald´s"))
        list.add(CarouselItem(R.drawable.gr_nachos, "Gran McExtreme de McDonald´s Nachos "))
        list.add(CarouselItem(R.drawable.gr_nachos_doble, "Gran McExtreme de McDonald´s Nachos Doble"))
        list.add(CarouselItem(R.drawable.gr_bacon, "Gran_McExtreme de McDonald´s Bacon"))
        list.add(CarouselItem(R.drawable.gr_bacon_doble, "Gran McExtreme de McDonald´s Doble"))
        //Add photos to the carrousel
        carrousel3.addData(list)
        // Carousel listener
        carrousel3.carouselListener = object : CarouselListener {
            override fun onClick(position: Int, carouselItem: CarouselItem) {
                //https://youtu.be/ZnarHv_Jx-M?t=953
                Toast.makeText(
                    this@McDonalds,
                    "MCDONALDS: ${carouselItem.caption}",
                    Toast.LENGTH_SHORT
                ).show()

            }

            override fun onLongClick(position: Int, dataObject: CarouselItem) {
                // ...
            }
        }
        //Fin de Carrousel 3
        //--------------------------------------------------------------------------------------------------------------------
        //Carrousel 4
        // Find carrousel id
        val carrousel4: ImageCarousel = findViewById(R.id.carousel4)
        //Add content to the array
        list.add(CarouselItem(R.drawable.postres_helados, "Postres y helados"))
        list.add(CarouselItem(R.drawable.mcflurry_su_cho_ne, "McFlurry Suchard Chocolate Negro "))
        list.add(CarouselItem(R.drawable.mcflurry_su_cho_bl, "McFlurry Suchard Chocolate Blanco"))
        list.add(CarouselItem(R.drawable.mcflurry_con_cho_le, "McFlurry Conguitos Chocolate con Leche"))
        list.add(CarouselItem(R.drawable.mcflurry_con_cho_bl, "McFlurry Conguitos Chocolate Blanco"))
        list.add(CarouselItem(R.drawable.mcflurry_kitkat, "McFlurry KitKat "))
        list.add(CarouselItem(R.drawable.mcflurry_oreo, "McFlurry Oreo"))
        list.add(CarouselItem(R.drawable.mcflurry_oreo_cho_bl, "McFlurry Oreo Chocolate Blanco "))
        list.add(CarouselItem(R.drawable.apple_pie, "Apple Pie"))
        list.add(CarouselItem(R.drawable.cono_helado, "Cono de helado "))
        list.add(CarouselItem(R.drawable.sun_choco, "Sundae Chocolate "))
        list.add(CarouselItem(R.drawable.sun_cara, "Sundae Caramelo "))
        list.add(CarouselItem(R.drawable.sun_fresa, "Sundae Fresa"))
        list.add(CarouselItem(R.drawable.sun_cho_bl, "Sundae Chocolate Blanco"))

        //Add photos to the carrousel
        carrousel4.addData(list)

        // Carousel listener
        carrousel4.carouselListener = object : CarouselListener {
            override fun onClick(position: Int, carouselItem: CarouselItem) {
                //https://youtu.be/ZnarHv_Jx-M?t=953
                Toast.makeText(this@McDonalds, "MCDONALDS: ${carouselItem.caption}", Toast.LENGTH_SHORT).show()

            }

            override fun onLongClick(position: Int, dataObject: CarouselItem) {

            }
        }
        // ...
        //Fin de Carrousel 4
        //-------------------------------------------------------------------------------------------------------------------
        //Listener del menu
        //Cambiar a pantalla burger king
        val burgerKing: ImageView = findViewById(R.id.BurgerBtn)
        burgerKing.setOnClickListener{
            CambiarPantallaBurger();
        }

        //Cambiar a pantalla mcdonals
        val mcDonalds: ImageView = findViewById(R.id.McDonaldsBtn)
        mcDonalds.setOnClickListener{
            CambiarPantallaMcDonalds();
        }

        //Cambiar a pantalla KFC
        val KFC: ImageView = findViewById(R.id.KFCBtn)
        KFC.setOnClickListener{
            CambiarPantallaKFC();
        }

        //Cambiar a pantalla taco bell
        val tacoBell: ImageView = findViewById(R.id.TacoBellBtn)
        tacoBell.setOnClickListener{
            CambiarPantallaTacoBell();
        }
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_tres_puntos, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val item_selected: Int = item.itemId

        if (item_selected == R.id.item1) {
            cambiarPantallaCuenta()
        }

        if (item_selected == R.id.item2) {
            Firebase.auth.signOut()
            val loginIntent = Intent(this, activity_login::class.java)
            startActivity(loginIntent)
        }
        return super.onOptionsItemSelected(item)
    }

    fun cambiarPantallaCuenta(){
        val loginIntent = Intent(this, Cuenta::class.java)
        startActivity(loginIntent)
    }


    fun CambiarPantallaBurger() {
        val loginIntent = Intent(this, BurgerKing::class.java)
        startActivity(loginIntent)
    }

    fun CambiarPantallaMcDonalds() {
        val loginIntent = Intent(this, McDonalds::class.java)
        startActivity(loginIntent)
    }
    fun CambiarPantallaKFC() {
        val loginIntent = Intent(this, KFC::class.java)
        startActivity(loginIntent)
    }

    fun CambiarPantallaTacoBell() {
        val loginIntent = Intent(this, TacoBell::class.java)
        startActivity(loginIntent)
    }

    fun CambiarPantallaMapa() {
        val loginIntent = Intent(this, MapsActivity::class.java)
        startActivity(loginIntent)
    }
}


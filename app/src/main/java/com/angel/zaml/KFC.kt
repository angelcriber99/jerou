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

class KFC : AppCompatActivity() {
    val list = mutableListOf<CarouselItem>()
    val list2 = mutableListOf<CarouselItem>()
    val list3 = mutableListOf<CarouselItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kfc)

        //Carrousel 1
        //Find carrousel id
        val carousel1: ImageCarousel = findViewById(R.id.carousel1)
        //Add content to the array
        list.add(CarouselItem(R.drawable.kfc_burger_bbc_burguer, "BBQ Burger"))
        list.add(CarouselItem(R.drawable.kfc_burger_original_burger, "Original Burger"))
        list.add(CarouselItem(R.drawable.kfc_burger_sobrada, "Burger Sobrada"))
        list.add(CarouselItem(R.drawable.kfc_burger_twister_wrap, "Burger Twister Wrap"))

        //Add photos to the carrousel
        carousel1.addData(list)

        // Carousel listener
        carousel1.carouselListener = object : CarouselListener {
            override fun onClick(position: Int, carouselItem: CarouselItem) {
                //https://youtu.be/ZnarHv_Jx-M?t=953
                Toast.makeText(this@KFC, "KFC: ${carouselItem.caption}", Toast.LENGTH_SHORT).show()
            }

            override fun onLongClick(position: Int, dataObject: CarouselItem) {
                // ...
            }

        }
        //Fin de Carrousel 1
        //---------------------------------------------------------------------------------------------------------
        //Carrousel 2
        //Find carrousel id
        val carousel2: ImageCarousel = findViewById(R.id.carousel2)
        //Add content to the array
        list2.add(CarouselItem(R.drawable.kfc_menu2_bucket_docetiras_dossalsas, "Menu Bucket 12 tiras con 2 salsas"))
        list2.add(CarouselItem(R.drawable.kfc_menu2_bucket_sietetiras_sietealitas, "Menu Bucket 7 tiras con 7 alitas"))
        list2.add(CarouselItem(R.drawable.kfc_menu2_catorce_alitaspicantes, "Menu 14 alitas picantes"))

        //Add photos to the carrousel
        carousel2.addData(list2)

        // Carousel listener
        carousel2.carouselListener = object : CarouselListener {
            override fun onClick(position: Int, carouselItem: CarouselItem) {
                //https://youtu.be/ZnarHv_Jx-M?t=953
                Toast.makeText(this@KFC, "KFC: ${carouselItem.caption}", Toast.LENGTH_SHORT).show()
            }

            override fun onLongClick(position: Int, dataObject: CarouselItem) {
                // ...
            }

        }
        //Fin de Carrousel 2
        //---------------------------------------------------------------------------------------------------------
        //Carrousel 3
        //Find carrousel id
        val carousel3: ImageCarousel = findViewById(R.id.carousel3)
        //Add content to the array
        list3.add(CarouselItem(R.drawable.kfc_complementos_emmental_bites, "Emmental Bites"))
        list3.add(CarouselItem(R.drawable.kfc_complementos_fries_cheese_bacon, "Fries cheese bacon"))
        list3.add(CarouselItem(R.drawable.kfc_complementos_mazorca, "Mazorca de maiz"))
        list3.add(CarouselItem(R.drawable.kfc_complementos_patatas_fritas, "Patatas fritas"))

        //Add photos to the carrousel
        carousel3.addData(list3)

        // Carousel listener
        carousel3.carouselListener = object : CarouselListener {
            override fun onClick(position: Int, carouselItem: CarouselItem) {
                //https://youtu.be/ZnarHv_Jx-M?t=953
                Toast.makeText(this@KFC, "KFC: ${carouselItem.caption}", Toast.LENGTH_SHORT).show()
            }

            override fun onLongClick(position: Int, dataObject: CarouselItem) {
                // ...
            }

        }
        //Fin de Carrousel 3
        //---------------------------------------------------------------------------------------------------------

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
            val loginIntent = Intent(this, MapsActivity::class.java)
            startActivity(loginIntent)
        }
        if (item_selected == R.id.item3) {
            val loginIntent = Intent(this, Carrito::class.java)
            startActivity(loginIntent)
        }
        return super.onOptionsItemSelected(item)
    }
    //Cambiar a la pantalla Cuenta
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
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

class TacoBell : AppCompatActivity() {
    val list = mutableListOf<CarouselItem>()
    val list2 = mutableListOf<CarouselItem>()
    val list3 = mutableListOf<CarouselItem>()
    val list4 = mutableListOf<CarouselItem>()
    val list5 = mutableListOf<CarouselItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taco_bell)

        //Carrousel 1
        //Find carrousel id
        val carousel1: ImageCarousel = findViewById(R.id.carousel1)
        //Add content to the array
        list.add(CarouselItem(R.drawable.tacobell_burritos_burrito_bowl_mexican, "Burrito bowl mexican"))
        list.add(CarouselItem(R.drawable.tacobell_burritos_burrito_santa_monica, "Burrito santa monica"))
        list.add(CarouselItem(R.drawable.tacobell_burritos_burrito_supreme, "Burrito supreme"))
        list.add(CarouselItem(R.drawable.tacobell_burritos_quesarrito, "Quesarrito"))


        //Add photos to the carrousel
        carousel1.addData(list)

        // Carousel listener
        carousel1.carouselListener = object : CarouselListener {
            override fun onClick(position: Int, carouselItem: CarouselItem) {
                //https://youtu.be/ZnarHv_Jx-M?t=953
                Toast.makeText(this@TacoBell, "Taco Bell: ${carouselItem.caption}", Toast.LENGTH_SHORT).show()
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
        list2.add(CarouselItem(R.drawable.tacobell_complementos_bacon_top_fries, "Bacon top fries"))
        list2.add(CarouselItem(R.drawable.tacobell_complementos_chicken_nachos, "Chicken nachos"))
        list2.add(CarouselItem(R.drawable.tacobell_complementos_nachos_carne_queso, "Nachos con carne y queso"))
        list2.add(CarouselItem(R.drawable.tacobell_complementos_patatas_mexican, "Patatas mexican"))
        list2.add(CarouselItem(R.drawable.tacobell_complementos_spicy_chicken_nachos, "Spicy chicken nachos"))

        //Add photos to the carrousel
        carousel2.addData(list2)

        // Carousel listener
        carousel2.carouselListener = object : CarouselListener {
            override fun onClick(position: Int, carouselItem: CarouselItem) {
                //https://youtu.be/ZnarHv_Jx-M?t=953
                Toast.makeText(this@TacoBell, "Taco Bell: ${carouselItem.caption}", Toast.LENGTH_SHORT).show()
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
        list3.add(CarouselItem(R.drawable.tacobell_menus_burrito_bowl_guacamole, "Burrito bowl guacamole"))
        list3.add(CarouselItem(R.drawable.tacobell_menus_chicken_burrito, "Chicken burrito"))
        list3.add(CarouselItem(R.drawable.tacobell_menus_crunchywrap_supreme, "Crunchywrap supreme"))
        list3.add(CarouselItem(R.drawable.tacobell_menus_gran_burrito, "Gran burrito"))
        list3.add(CarouselItem(R.drawable.tacobell_menus_quesarrito, "Quesarrito"))

        //Add photos to the carrousel
        carousel3.addData(list3)

        // Carousel listener
        carousel3.carouselListener = object : CarouselListener {
            override fun onClick(position: Int, carouselItem: CarouselItem) {
                //https://youtu.be/ZnarHv_Jx-M?t=953
                Toast.makeText(this@TacoBell, "Taco Bell: ${carouselItem.caption}", Toast.LENGTH_SHORT).show()
            }

            override fun onLongClick(position: Int, dataObject: CarouselItem) {
                // ...
            }

        }
        //Fin de Carrousel 3
        //---------------------------------------------------------------------------------------------------------
        //Carrousel 4
        //Find carrousel id
        val carousel4: ImageCarousel = findViewById(R.id.carousel4)
        //Add content to the array
        list4.add(CarouselItem(R.drawable.tacobell_quesadilla_queso, "Quesadilla con queso"))
        list4.add(CarouselItem(R.drawable.tacobell_quesadilla_kidquesadilla, "Kidquesadilla"))

        //Add photos to the carrousel
        carousel4.addData(list4)

        // Carousel listener
        carousel4.carouselListener = object : CarouselListener {
            override fun onClick(position: Int, carouselItem: CarouselItem) {
                //https://youtu.be/ZnarHv_Jx-M?t=953
                Toast.makeText(this@TacoBell, "Taco Bell: ${carouselItem.caption}", Toast.LENGTH_SHORT).show()
            }

            override fun onLongClick(position: Int, dataObject: CarouselItem) {
                // ...
            }

        }
        //Fin de Carrousel 4
        //---------------------------------------------------------------------------------------------------------
        //Carrousel 5
        //Find carrousel id
        val carousel5: ImageCarousel = findViewById(R.id.carousel5)
        //Add content to the array
        list5.add(CarouselItem(R.drawable.tacobell_taco, "Taco"))
        list5.add(CarouselItem(R.drawable.tacobell_taco_supreme, "Taco supreme"))

        //Add photos to the carrousel
        carousel5.addData(list5)

        // Carousel listener
        carousel5.carouselListener = object : CarouselListener {
            override fun onClick(position: Int, carouselItem: CarouselItem) {
                //https://youtu.be/ZnarHv_Jx-M?t=953
                Toast.makeText(this@TacoBell, "Taco Bell: ${carouselItem.caption}", Toast.LENGTH_SHORT).show()
            }

            override fun onLongClick(position: Int, dataObject: CarouselItem) {
                // ...
            }

        }
        //Fin de Carrousel 5

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
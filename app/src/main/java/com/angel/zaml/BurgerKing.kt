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

class BurgerKing : AppCompatActivity() {
    val list = mutableListOf<CarouselItem>()
    val list2 = mutableListOf<CarouselItem>()
    val list3 = mutableListOf<CarouselItem>()
    val list4 = mutableListOf<CarouselItem>()
    val list5 = mutableListOf<CarouselItem>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_burger_king)

        // Carrousel 1
        //Find carrousel id
        val carrousel1: ImageCarousel = findViewById(R.id.carousel1)
        //Add content to the array
        list.add(CarouselItem(R.drawable.menu_parrilla, "Menú Parrilla"))
        list.add(CarouselItem(R.drawable.che_duo_ba_2c, "Menú Duo Bacon Cheddar 2 Carnes"))
        list.add(CarouselItem(R.drawable.che_duo_ba_1c, "Menú Duo Bacon Cheddar 1 Carne"))
        list.add(CarouselItem(R.drawable.menu_whopper, "Menú Whopper"))
        list.add(CarouselItem(R.drawable.menu_do_chee_ba_xxl, "Menú Doble Cheese Bacon XXL"))
        list.add(CarouselItem(R.drawable.menu_steakhouse, "Menú SteakHouse"))
        list.add(CarouselItem(R.drawable.menu_king_bacon, "Menú The King Bacon"))
        list.add(CarouselItem(R.drawable.menu_king_huevo, "Menú The King Huevo"))
        list.add(CarouselItem(R.drawable.menu_doble_whopper, "Menú Doble Whopper"))
        list.add(CarouselItem(R.drawable.menu_whopper_sin_gluten, "Menú Whopper Sin Gluten"))

        //Add photos to the carrousel
        carrousel1.addData(list)

        // Carousel listener
        carrousel1.carouselListener = object : CarouselListener {
            override fun onClick(position: Int, carouselItem: CarouselItem) {
                //https://youtu.be/ZnarHv_Jx-M?t=953
                Toast.makeText(this@BurgerKing, "BURGERKING: ${carouselItem.caption}", Toast.LENGTH_SHORT).show()

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
        list2.add(CarouselItem(R.drawable.menu_pollo, "Menú Pollo"))
        list2.add(CarouselItem(R.drawable.menu_duo_ba_chee_do_cris_chi, "Menú Duo Bacon Cheedar-Doble Crispy Chicken"))
        list2.add(CarouselItem(R.drawable.menu_chi_ten, "Menú Chicken Tendercrisp"))
        list2.add(CarouselItem(R.drawable.menu_do_cri_chi, "Menú Doble Crispy Chicken "))
        list2.add(CarouselItem(R.drawable.menu_cri_chi, "Menú Crispy Chicken"))
        list2.add(CarouselItem(R.drawable.menu_lon_chi, "Menú Long Chicken"))
        list2.add(CarouselItem(R.drawable.menu_chi_wrap, "Menú Chicken WRAP"))
        list2.add(CarouselItem(R.drawable.menu_chi_nug, "Menú Chicken Nuggets(X9)"))



        //Add photos to the carrousel
        carrousel2.addData(list2)

        // Carousel listener
        carrousel2.carouselListener = object : CarouselListener {
            override fun onClick(position: Int, carouselItem: CarouselItem) {
                //https://youtu.be/ZnarHv_Jx-M?t=953
                Toast.makeText(this@BurgerKing, "BURGERKING: ${carouselItem.caption}", Toast.LENGTH_SHORT).show()
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
        list3.add(CarouselItem(R.drawable.hamburguesas_bk, "Hamburguesas"))
        list3.add(CarouselItem(R.drawable.triple_whopper, "Triple Whopper"))
        list3.add(CarouselItem(R.drawable.big_king, "Big King"))
        list3.add(CarouselItem(R.drawable.steakhouse, "Steakhouse"))
        list3.add(CarouselItem(R.drawable.crispy_chicken, "Crispy Chicken"))
        list3.add(CarouselItem(R.drawable.chicken_wrap, "Chicken WRAP"))
        list3.add(CarouselItem(R.drawable.long_chicken, "Long Chicken"))
        list3.add(CarouselItem(R.drawable.doble_cheese_bacon, "Doble Cheese Bacon"))
        list3.add(CarouselItem(R.drawable.cheeseburger, "CheeseBurger"))
        list3.add(CarouselItem(R.drawable.whopper_vegetal, "Whopper Vegetal"))


        //Add photos to the carrousel
        carrousel3.addData(list3)

        // Carousel listener
        carrousel3.carouselListener = object : CarouselListener {
            override fun onClick(position: Int, carouselItem: CarouselItem) {
                //https://youtu.be/ZnarHv_Jx-M?t=953
                Toast.makeText(this@BurgerKing, "BURGERKING: ${carouselItem.caption}", Toast.LENGTH_SHORT).show()

            }

            override fun onLongClick(position: Int, dataObject: CarouselItem) {
                // ...
            }
        }

        //Fin de Carrousel 3
        //------------------------------------------------------------------------------------------------------------------------------
        //Carrousel 4
        // Find carrousel id
        val carrousel4: ImageCarousel = findViewById(R.id.carousel4)
        //Add content to the array
        list4.add(CarouselItem(R.drawable.postres_bk, "Postres"))
        list4.add(CarouselItem(R.drawable.shakes, "Shakes"))
        list4.add(CarouselItem(R.drawable.king_fusion, "King Fusion"))
        list4.add(CarouselItem(R.drawable.burger_king_sandy, "Burger King Sandy"))
        list4.add(CarouselItem(R.drawable.cono_helado_bk, "Cono Helado"))
        list4.add(CarouselItem(R.drawable.gofre_caliente, "Gofre Caliente"))
        list4.add(CarouselItem(R.drawable.brownie, "Brownie"))
        list4.add(CarouselItem(R.drawable.magnum, "Magnum Almendrado (465ML)"))


        //Add photos to the carrousel
        carrousel4.addData(list4)

        // Carousel listener
        carrousel4.carouselListener = object : CarouselListener {
            override fun onClick(position: Int, carouselItem: CarouselItem) {
                //https://youtu.be/ZnarHv_Jx-M?t=953
                Toast.makeText(this@BurgerKing, "BURGERKING: ${carouselItem.caption}", Toast.LENGTH_SHORT).show()

            }

            override fun onLongClick(position: Int, dataObject: CarouselItem) {
                // ...
            }
        }


        //Fin de Carrousel 4
        //------------------------------------------------------------------------------------------------------------------------------
        //Carrousel 5
        // Find carrousel id
        val carrousel5: ImageCarousel = findViewById(R.id.carousel5)
        //Add content to the array
        list5.add(CarouselItem(R.drawable.entrantes_snacks, "Entrantes y Snacks"))
        list5.add(CarouselItem(R.drawable.dots_gouda, "Dots de Gouda"))
        list5.add(CarouselItem(R.drawable.alitas_pollo, "Alitas de Pollo"))
        list5.add(CarouselItem(R.drawable.nuggets_vegetales, "Nuggets Vegetales"))
        list5.add(CarouselItem(R.drawable.chicken_nuggets, "Chicken Nuggets"))
        list5.add(CarouselItem(R.drawable.patatas_clasicas, "Patatas Clásicas"))
        list5.add(CarouselItem(R.drawable.patatas_supreme, "Patatas Supreme"))
        list5.add(CarouselItem(R.drawable.aros_cebolla, "King Aros de Cebolla"))
        list5.add(CarouselItem(R.drawable.delicias_pollo, "Delicias de Pollo"))
        list5.add(CarouselItem(R.drawable.chili_chee_bites, "Chili Cheese Bites"))
        list5.add(CarouselItem(R.drawable.fries_1, "King Fries (Cheddar + Bacon + Cebolla "))
        list5.add(CarouselItem(R.drawable.supreme_1, "King Supreme (Cheddar + Bacon + Cebolla"))

        //Add photos to the carrousel
        carrousel5.addData(list5)

        // Carousel listener
        carrousel5.carouselListener = object : CarouselListener {
            override fun onClick(
                position: Int,
                carouselItem: CarouselItem
            ) {
                //https://youtu.be/ZnarHv_Jx-M?t=953
                Toast.makeText(this@BurgerKing, "BURGERKING: ${carouselItem.caption}", Toast.LENGTH_SHORT).show()

            }

            override fun onLongClick(position: Int, dataObject: CarouselItem) {
                // ...

            }
        }
        //Fin de Carrousel 5
        //------------------------------------------------------------------------------------------------------------------------------

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

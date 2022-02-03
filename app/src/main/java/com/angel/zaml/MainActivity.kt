package com.angel.zaml

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.listener.CarouselListener
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    val list = mutableListOf<CarouselItem>()
    val list2 = mutableListOf<CarouselItem>()
    val list3 = mutableListOf<CarouselItem>()
    val list4 = mutableListOf<CarouselItem>()
    //view binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Carrousel 1
        //Find carrousel id
        val carousel1: ImageCarousel = findViewById(R.id.carousel1)
        //Add content to the array
        list.add(CarouselItem(R.drawable.burgerking_originals_campesina, "Originals Campesina"))
        list.add(CarouselItem(R.drawable.burgerking_originals_mediterranea, "Originals Mediterranea"))
        list.add(CarouselItem(R.drawable.burgerking_vegetariana, "Vegetariana"))
        list.add(CarouselItem(R.drawable.burgerking_whopper, "Whopper"))
        list.add(CarouselItem(R.drawable.burguerking_baconking, "Bacon King"))

        //Add photos to the carrousel
        carousel1.addData(list)

        // Carousel listener
        carousel1.carouselListener = object : CarouselListener {
            override fun onClick(position: Int, carouselItem: CarouselItem) {
                //https://youtu.be/ZnarHv_Jx-M?t=953
                Toast.makeText(this@MainActivity, "Burguer King: ${carouselItem.caption}", Toast.LENGTH_SHORT).show()
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
        list2.add(CarouselItem(R.drawable.mcdonalds_cbo, "Cbo"))
        list2.add(CarouselItem(R.drawable.mcdonalds_happymeal, "Happy Meal"))
        list2.add(CarouselItem(R.drawable.mcdonalds_mcaitana, "McAitana"))
        list2.add(CarouselItem(R.drawable.mcdonalds_menuforyou, "Menu for you"))

        //Add photos to the carrousel
        carousel2.addData(list2)

        // Carousel listener
        carousel2.carouselListener = object : CarouselListener {
            override fun onClick(position: Int, carouselItem: CarouselItem) {
                //https://youtu.be/ZnarHv_Jx-M?t=953
                Toast.makeText(this@MainActivity, "McDonalds: ${carouselItem.caption}", Toast.LENGTH_SHORT).show()
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
        list3.add(CarouselItem(R.drawable.kfc_antonia, "Menu Antonia"))
        list3.add(CarouselItem(R.drawable.kfc_cubodos, "Cubo para 2 personas"))
        list3.add(CarouselItem(R.drawable.kfc_menusobrada, "Menu Sobrada"))
        list3.add(CarouselItem(R.drawable.kfc_piezascoronel, "Piezas del coronel"))
        list3.add(CarouselItem(R.drawable.kfc_twoburgers, "Menu two burguers"))

        //Add photos to the carrousel
        carousel3.addData(list3)

        // Carousel listener
        carousel3.carouselListener = object : CarouselListener {
            override fun onClick(position: Int, carouselItem: CarouselItem) {
                //https://youtu.be/ZnarHv_Jx-M?t=953
                Toast.makeText(this@MainActivity, "KFC: ${carouselItem.caption}", Toast.LENGTH_SHORT).show()
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
        list4.add(CarouselItem(R.drawable.tacobell_burritobowl, "Menu BurritoBowl"))
        list4.add(CarouselItem(R.drawable.tacobell_crunchywrap, "Menu crunchywrap"))
        list4.add(CarouselItem(R.drawable.tacobell_granburrito, "Gran burrito"))
        list4.add(CarouselItem(R.drawable.tacobell_quesadilla, "Menu Quesadilla"))
        list4.add(CarouselItem(R.drawable.tacobell_tacos, "Tacos"))

        //Add photos to the carrousel
        carousel4.addData(list4)

        // Carousel listener
        carousel4.carouselListener = object : CarouselListener {
            override fun onClick(position: Int, carouselItem: CarouselItem) {
                //https://youtu.be/ZnarHv_Jx-M?t=953
                Toast.makeText(this@MainActivity, "Taco Bell: ${carouselItem.caption}", Toast.LENGTH_SHORT).show()
            }

            override fun onLongClick(position: Int, dataObject: CarouselItem) {
                // ...
            }

        }
        //Fin de Carrousel 4

        //Menu Lateral izquierda

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout)

        toggle = ActionBarDrawerToggle( this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        //Cambiar a pantalla burger king
        val burgerKing:ImageView = findViewById(R.id.BurgerBtn)
        burgerKing.setOnClickListener{
            CambiarPantallaBurger();
        }

        //Cambiar a pantalla mcdonals
        val mcDonalds:ImageView = findViewById(R.id.McDonaldsBtn)
        mcDonalds.setOnClickListener{
            CambiarPantallaMcDonalds();
        }

        //Cambiar a pantalla burger king
        val KFC:ImageView = findViewById(R.id.KFCBtn)
        KFC.setOnClickListener{
            CambiarPantallaKFC();
        }

        //Cambiar a pantalla burger king
        val tacoBell:ImageView = findViewById(R.id.TacoBellBtn)
        tacoBell.setOnClickListener{
            CambiarPantallaTacoBell();
        }

    }
    //esta funcion crea menu de los tres puntos

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_tres_puntos, menu)
        return true
    }

   // override fun onOptionsItemSelected(item: MenuItem): Boolean {
   //     val item_selected: Int = item.itemId

    //    if (item_selected == R.id.cuenta_button) {
    //        cambiarPantallaCuenta()
    //    }
    //    return super.onOptionsItemSelected(item)
   // }
    //Cambiar a la pantalla Cuenta
    fun cambiarPantallaCuenta(){
        val loginIntent = Intent(this, Cuenta::class.java)
        startActivity(loginIntent)
    }

    fun CambiarPantallaBurger() {
        val loginIntent = Intent(this, MapsActivity::class.java)
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

    //Menu Lateral izquierda

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_item_one -> Toast.makeText(this, "Mapas", Toast.LENGTH_SHORT).show()
            R.id.nav_item_two -> Toast.makeText( this, "Página Web", Toast.LENGTH_SHORT).show()
            R.id.nav_item_three -> Toast.makeText( this, "Acerca de nosotros", Toast.LENGTH_SHORT).show()
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle. syncState()
    }
    override fun onConfigurationChanged (newConfig: Configuration) {
        super.onConfigurationChanged (newConfig)
        toggle.onConfigurationChanged (newConfig)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }



}
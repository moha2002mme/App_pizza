package com.example.myapp_pizza.activities


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp_pizza.R
import com.example.myapp_pizza.adabters.pizzaCardAdabter
import com.example.myapp_pizza.adabters.pizzaGridAdabter
import com.example.myapp_pizza.listPizza

class MainActivity : AppCompatActivity() {
    lateinit var gridView: GridView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Pizza Mhandanin"
        supportActionBar?.setBackgroundDrawable(resources.getDrawable(R.color.UltraLightGrey))
        supportActionBar?.setIcon(R.drawable.pizza_slice)

        gridView = findViewById<GridView>(R.id.gridView)

        var pizzaAdabter = pizzaCardAdabter(this, listPizza)
        gridView.adapter = pizzaAdabter



        gridView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, InfoActivity::class.java)
            intent.putExtra("pizza", position)
            startActivity(intent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_activity_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.grid -> {
                if (gridView.numColumns == 1) {
                    gridView.numColumns = 2
                    var pizzaAdabterGrid = pizzaGridAdabter(this, listPizza)
                    gridView.adapter = pizzaAdabterGrid
                } else {
                    gridView.numColumns = 1
                    var pizzaAdabter = pizzaCardAdabter(this, listPizza)
                    gridView.adapter = pizzaAdabter
                }
            }

            R.id.shoppingCart -> {
                val intent = Intent(this, PanierActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
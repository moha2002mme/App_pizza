package com.example.myapp_pizza.activities


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp_pizza.R
import com.example.myapp_pizza.listPizza


@Suppress("DEPRECATION")
class InfoActivity : AppCompatActivity() {
    private var recuperIntent: Int? = null
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.layout_info)


        supportActionBar?.title = "Pizza Mhandroha"
        supportActionBar?.setBackgroundDrawable(resources.getDrawable(R.color.UltraLightGrey))
        supportActionBar?.setIcon(R.drawable.pizza_slice)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        val pizzaImage = findViewById<ImageView>(R.id.pizzaImage)
        val pizzaName = findViewById<TextView>(R.id.pizzaName)
        val descriptionContent = findViewById<TextView>(R.id.descriptionContent)
        val ingredientContent = findViewById<TextView>(R.id.ingredientContent)

        recuperIntent = intent?.extras?.getInt("pizza")
        pizzaImage.setImageResource(listPizza[recuperIntent!!].image)
        pizzaName.text = listPizza[recuperIntent!!].name
        descriptionContent.text = listPizza[recuperIntent!!].description
        ingredientContent.text = listPizza[recuperIntent!!].ingredients.joinToString("\n")


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.pizzainfo_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.partager) {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND

                putExtra(Intent.EXTRA_TITLE, listPizza[recuperIntent!!].name)
                putExtra(Intent.EXTRA_TEXT, listPizza[recuperIntent!!].description)
                putExtra(Intent.EXTRA_STREAM, listPizza[recuperIntent!!].image)
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
        return super.onOptionsItemSelected(item)
    }
}

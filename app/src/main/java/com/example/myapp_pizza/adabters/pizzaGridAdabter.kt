package com.example.myapp_pizza.adabters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.myapp_pizza.Pizza
import com.example.myapp_pizza.R

class pizzaGridAdabter(var context: Context, var listPizza: List<Pizza>):BaseAdapter() {
    override fun getCount(): Int {
        return listPizza.size
    }

    override fun getItem(position: Int): Any {
        return listPizza[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view =  convertView ?: LayoutInflater.from(context).inflate(R.layout.pizza_card_grid_2, parent, false)

        var pizzaImage=view.findViewById<ImageView>(R.id.pizzaImage)
        var pizzaName=view.findViewById<TextView>(R.id.pizzaName)
        var temp=view.findViewById<TextView>(R.id.temp)
        var ingredient=view.findViewById<TextView>(R.id.ingredient)
        var prix=view.findViewById<TextView>(R.id.prix)

        var pizza = getItem(position) as Pizza

        pizzaImage.setImageResource(pizza.image)
        pizzaName.text=pizza.name
        temp.text=pizza.temp.toString()
        ingredient.text=pizza.ingredients.size.toString()
        prix.text="${pizza.prix.toString()} MAD"

        return view

    }
}
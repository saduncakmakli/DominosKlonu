package com.example.dominosklonu.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dominosklonu.Pizza
import com.example.dominosklonu.databinding.CardTasarimBinding

class PizzaAdapter (var mContext:Context, var pizzaListesi:List<Pizza>) : RecyclerView.Adapter<PizzaAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim:CardTasarimBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CardTasarimBinding.inflate(layoutInflater, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val pizza = pizzaListesi.get(position)
        val t = holder.tasarim

        t.pizzaNesnesi = pizza
        t.imageViewPizza.setImageResource(
            mContext.resources.getIdentifier(pizza.resim,"drawable", mContext.packageName))
        t.satirCard.setOnClickListener {
            //Carda tıklandığında yapılacaklar
        }
        t.buttonSiparisVer.setOnClickListener {
            //Butona tıklandığında yapılacaklar
        }
    }

    override fun getItemCount(): Int {
        return pizzaListesi.size
    }

}
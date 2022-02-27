package com.example.dominosklonu.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dominosklonu.adapter.adaptersData.Kampanya
import com.example.dominosklonu.databinding.CardKampanyaBinding

class KampanyaAdapter (var mContext:Context, var kampanyaListesi:List<Kampanya>) : RecyclerView.Adapter<KampanyaAdapter.CardKampanyaHolder>() {

    inner class CardKampanyaHolder(tasarim:CardKampanyaBinding) : RecyclerView.ViewHolder(tasarim.root) {
        var tasarim : CardKampanyaBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KampanyaAdapter.CardKampanyaHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CardKampanyaBinding.inflate(layoutInflater, parent, false)
        return CardKampanyaHolder(tasarim)
    }

    override fun onBindViewHolder(holder: KampanyaAdapter.CardKampanyaHolder, position: Int) {
        val kampanya = kampanyaListesi.get(position)
        val t = holder.tasarim

        t.kampanyaNesnesi = kampanya
        t.textView.setOnClickListener {
            //Yazıya tıklandığında yapılacaklar
        }
    }

    override fun getItemCount(): Int {
        return kampanyaListesi.size
    }
}
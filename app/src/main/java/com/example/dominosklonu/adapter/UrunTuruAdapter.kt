package com.example.dominosklonu.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dominosklonu.adapter.adaptersData.UrunTuru
import com.example.dominosklonu.databinding.CardUrunTurBinding

class UrunTuruAdapter (var mContext:Context, var urunTuruListesi:List<UrunTuru>) : RecyclerView.Adapter<UrunTuruAdapter.UrunTuruTutucu>() {

    inner class UrunTuruTutucu(tasarim:CardUrunTurBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim:CardUrunTurBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UrunTuruTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CardUrunTurBinding.inflate(layoutInflater, parent, false)
        return UrunTuruTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: UrunTuruTutucu, position: Int) {
        val urunTuru = urunTuruListesi.get(position)
        val t = holder.tasarim

        t.urunTuruNesnesi = urunTuru
        if (urunTuru.resim != "")
            t.imageViewUrunTur.setImageResource(mContext.resources.getIdentifier(urunTuru.resim, "drawable", mContext.packageName))
        else
            t.imageViewUrunTur.setImageResource(mContext.resources.getIdentifier(urunTuruListesi.get(1).resim, "drawable", mContext.packageName))
        t.cardViewUrunTuru.setOnClickListener {
            //Carda tıklandığında yapılacaklar
        }
    }

    override fun getItemCount(): Int {
        return urunTuruListesi.size
    }
}
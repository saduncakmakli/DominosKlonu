package com.example.dominosklonu.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dominosklonu.SliderItem
import com.example.dominosklonu.databinding.CardSliderBinding

class SliderAdapter(var mContext:Context, var sliderItemListesi:List<SliderItem>) : RecyclerView.Adapter<SliderAdapter.ViewHolder>() {

   inner class ViewHolder (tasarim:CardSliderBinding) : RecyclerView.ViewHolder(tasarim.root){
       var tasarim:CardSliderBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CardSliderBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(tasarim)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sliderItem = sliderItemListesi.get(position)
        val t = holder.tasarim

        t.sliderItemNesnesi = sliderItem
        t.imageViewKampanya.setImageResource(mContext.resources.getIdentifier(sliderItem.resim,"drawable", mContext.packageName))
        //On click methodları buraya eklenecek

    }

    override fun getItemCount(): Int {
        return sliderItemListesi.size
    }
}
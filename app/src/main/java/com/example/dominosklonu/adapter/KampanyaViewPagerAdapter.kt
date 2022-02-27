package com.example.dominosklonu.adapter

import android.content.Context
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dominosklonu.Kampanya
import com.example.dominosklonu.databinding.CardKampanyaBinding

class KampanyaViewPagerAdapter(var mContext:Context, var kampanyaListesi:List<Kampanya>) : RecyclerView.Adapter<KampanyaViewPagerAdapter.ViewHolder>() {

   inner class ViewHolder (tasarim:CardKampanyaBinding) : RecyclerView.ViewHolder(tasarim.root){
       var tasarim:CardKampanyaBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CardKampanyaBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(tasarim)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val kampanya = kampanyaListesi.get(position)
        val t = holder.tasarim

        t.kampanyaNesnesi = kampanya
        t.imageViewKampanya.setImageResource(mContext.resources.getIdentifier(kampanya.resim,"drawable", mContext.packageName))
        //On click methodları buraya eklenecek

    }

    override fun getItemCount(): Int {
        return kampanyaListesi.size
    }
}
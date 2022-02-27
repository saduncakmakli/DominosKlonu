package com.example.dominosklonu.fragment

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.dominosklonu.adapter.adaptersData.Pizza
import com.example.dominosklonu.R
import com.example.dominosklonu.adapter.adaptersData.SliderItem
import com.example.dominosklonu.adapter.PizzaAdapter
import com.example.dominosklonu.adapter.SliderAdapter
import com.example.dominosklonu.databinding.FragmentAnasayfaBinding

class FragmentAnasayfa : Fragment() {
    lateinit var tasarim:FragmentAnasayfaBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_anasayfa, container, false)
        tasarim.anasayfaFragment = this
        tasarim.rvKampanya.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)




        val pizzaListesi = ArrayList<Pizza>()
        val p1 = Pizza(1, "Gel Al - 2 Büyük Boy Pizza + Coca-Cola Pet 1 lt", "gel_al_2_buyuk_boy_pizza_coca_cola_pet_1_lt", 86.99)
        val p2 = Pizza(2, "Gel Al - 2 Orta Boy Bol Malzemos", "gel_al_2_orta_boy_bol_malzemos", 64.99)
        val p3 = Pizza(3, "Gel Al - 2 Orta Boy Pizza + Coca-Cola Pet 1 lt", "gel_al_2_orta_boy_pizza_coca_cola_pet_1_lt", 74.99)

        pizzaListesi.add(p1)
        pizzaListesi.add(p2)
        pizzaListesi.add(p3)

        val adapter = PizzaAdapter(requireContext(),pizzaListesi)
        tasarim.pizzaAdapter = adapter

        val kampanyaListesi = ArrayList<SliderItem>()
        val k1 = SliderItem(1, "kampanya1")
        val k2 = SliderItem(2, "kampanya2")
        val k3 = SliderItem(3, "kampanya3")

        kampanyaListesi.add(k1)
        kampanyaListesi.add(k2)
        kampanyaListesi.add(k3)

        val kampanyaAdapter = SliderAdapter(requireContext(),kampanyaListesi)
        tasarim.kampanyaAdapter = kampanyaAdapter

        var position = 0
        var firstOpen = true
        val countDownInterval:Long = 5000
        val timer = object: CountDownTimer((countDownInterval*kampanyaListesi.size*5+2), countDownInterval) {
            override fun onTick(millisUntilFinished: Long) {
                if (!firstOpen){
                    if (position++ < kampanyaListesi.size-1){ }
                    else {
                        position = 0
                    }
                    tasarim.rvKampanya.smoothScrollToPosition(position)
                }
                else firstOpen = false
                Log.e("Debugg", "Position = ${position}")
            }
            override fun onFinish() {}
        }
        timer.start()


        return tasarim.root
    }
}
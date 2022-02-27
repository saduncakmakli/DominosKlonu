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
import com.example.dominosklonu.adapter.KampanyaAdapter
import com.example.dominosklonu.adapter.adaptersData.SliderItem
import com.example.dominosklonu.adapter.PizzaAdapter
import com.example.dominosklonu.adapter.SliderAdapter
import com.example.dominosklonu.adapter.UrunTuruAdapter
import com.example.dominosklonu.adapter.adaptersData.Kampanya
import com.example.dominosklonu.adapter.adaptersData.UrunTuru
import com.example.dominosklonu.databinding.FragmentAnasayfaBinding

class FragmentAnasayfa : Fragment() {
    lateinit var tasarim:FragmentAnasayfaBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_anasayfa, container, false)
        tasarim.anasayfaFragment = this

        val pizzaListesi = ArrayList<Pizza>()
        val p1 = Pizza(1, "Gel Al - 2 Büyük Boy Pizza + Coca-Cola Pet 1 lt", "gel_al_2_buyuk_boy_pizza_coca_cola_pet_1_lt", 86.99)
        val p2 = Pizza(2, "Gel Al - 2 Orta Boy Bol Malzemos", "gel_al_2_orta_boy_bol_malzemos", 64.99)
        val p3 = Pizza(3, "Gel Al - 2 Orta Boy Pizza + Coca-Cola Pet 1 lt", "gel_al_2_orta_boy_pizza_coca_cola_pet_1_lt", 74.99)

        pizzaListesi.add(p1)
        pizzaListesi.add(p2)
        pizzaListesi.add(p3)

        val adapter = PizzaAdapter(requireContext(),pizzaListesi)
        tasarim.pizzaAdapter = adapter

        tasarim.rvSlider.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL) //RecycleView Setting
        val sliderListesi = ArrayList<SliderItem>()
        val s1 = SliderItem(1, "kampanya1")
        val s2 = SliderItem(2, "kampanya2")
        val s3 = SliderItem(3, "kampanya3")

        sliderListesi.add(s1)
        sliderListesi.add(s2)
        sliderListesi.add(s3)

        val sliderAdapter = SliderAdapter(requireContext(),sliderListesi)
        tasarim.sliderAdapter = sliderAdapter

        tasarim.rvKampanya.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL) //RecycleView Setting
        val kampanyaListesi = ArrayList<Kampanya>()
        val k1 = Kampanya(1, "Gel Al Haftanın Kampanyaları")
        val k2 = Kampanya(2,"Beklemeden Gel Al Özel")
        val k3 = Kampanya(3, "Gel Al 40 TL Altı Lezzetler")
        val k4 = Kampanya(4,"Gel Al Bol Lezzetler")
        val k5 = Kampanya(5, "Gel Al Tek Kişilik")
        val k6 = Kampanya(6, "Gel Al 2-3 Kişilik")
        val k7 = Kampanya(7, "Gel Al 4 Kişi ve Üzeri")
        val k8 = Kampanya(8, "Uygulamaya Özel Fırsatlar")
        val k9 = Kampanya(9, "Haftanın Kampanyaları")
        val k10 = Kampanya(10, "50 TL Altı Lezzetler")
        val k11 = Kampanya(11, "Bol Lezzetler")
        val k12 = Kampanya(12, "Tek Kişilik Kampanyalar")
        val k13 = Kampanya(13, "2-3 Kişilik Kampanyalar")
        val k14 = Kampanya(14, "4 Kişi ve Üzeri Kampanyalar")

        kampanyaListesi.add(k1)
        kampanyaListesi.add(k2)
        kampanyaListesi.add(k3)
        kampanyaListesi.add(k4)
        kampanyaListesi.add(k5)
        kampanyaListesi.add(k6)
        kampanyaListesi.add(k7)
        kampanyaListesi.add(k8)
        kampanyaListesi.add(k9)
        kampanyaListesi.add(k10)
        kampanyaListesi.add(k11)
        kampanyaListesi.add(k12)
        kampanyaListesi.add(k13)
        kampanyaListesi.add(k14)

        val kampanyaAdapter = KampanyaAdapter(requireContext(), kampanyaListesi)
        tasarim.kampanyaAdapter = kampanyaAdapter

        tasarim.rvUrunTuru.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL) //RecycleView Setting
        val urunTuruListesi = ArrayList<UrunTuru>()
        val u1 = UrunTuru(1,"Kampanya", "kampanya")
        val u2 = UrunTuru(2,"Pizza", "pizza")
        val u3 = UrunTuru(3,"İçecekler","")
        val u4 = UrunTuru(4,"Dürümler","")
        val u5 = UrunTuru(5, "Ekmek Arası", "")
        val u6 = UrunTuru(6, "Tavuklar", "")
        val u7 = UrunTuru(7,"Makarnalar","")
        val u8 = UrunTuru(8, "Patates & Cips", "")
        val u9 = UrunTuru(9, "Tatlılar", "")
        val u10 = UrunTuru(10, "Tostilla", "")
        val u11 = UrunTuru(11, "Ekmekler", "")
        val u12 = UrunTuru(12, "Soslar", "")

        urunTuruListesi.add(u1)
        urunTuruListesi.add(u2)
        urunTuruListesi.add(u3)
        urunTuruListesi.add(u4)
        urunTuruListesi.add(u5)
        urunTuruListesi.add(u6)
        urunTuruListesi.add(u7)
        urunTuruListesi.add(u8)
        urunTuruListesi.add(u9)
        urunTuruListesi.add(u10)
        urunTuruListesi.add(u11)
        urunTuruListesi.add(u12)

        val urunTuruAdapter = UrunTuruAdapter(requireContext(), urunTuruListesi)
        tasarim.urunTuruAdapter = urunTuruAdapter

        //Slider Oto-Slide
        var position = 0
        var firstOpen = true
        val countDownInterval:Long = 5000
        val timer = object: CountDownTimer((countDownInterval*sliderListesi.size*5+2), countDownInterval) {
            override fun onTick(millisUntilFinished: Long) {
                if (!firstOpen){
                    if (position++ < sliderListesi.size-1){ }
                    else {
                        position = 0
                    }
                    tasarim.rvSlider.smoothScrollToPosition(position)
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
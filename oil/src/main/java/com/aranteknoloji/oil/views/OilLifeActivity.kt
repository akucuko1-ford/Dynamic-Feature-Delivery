package com.aranteknoloji.oil.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aranteknoloji.oil.R
import kotlinx.android.synthetic.main.activity_oil_life.*

class OilLifeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oil_life)

        oil_life_des.text = "merhaba canim"
    }
}
package com.baraamasri.konverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun convertBlyat(view: View) {

        //view as Button
        welcomeText.text = if(!boxesEmpty())
            SuperConverter.convert(
            number.text.toString(),
            base.text.toString().toInt(),
            targetBase.text.toString().toInt()
        ) else "Fill boxes blyat!!"


    }

    private fun boxesEmpty(): Boolean {

        return  number.text.isEmpty() &&
                base.text.isEmpty() &&
                targetBase.text.isEmpty()
    }
}
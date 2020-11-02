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

    fun convert(view: View) {

        //view as Button
        welcomeText.text = if(!boxesEmpty() &&
            isBaseValid(base.text.toString().toInt()) &&
            isBaseValid(targetBase.text.toString().toInt()))
            SuperConverter.convert(
            validateNumber( number.text.toString() ),
            base.text.toString().toInt(),
            targetBase.text.toString().toInt()
        ) else "Fill boxes correctly blyat!!"


    }

    private fun boxesEmpty(): Boolean {

        return  number.text.isEmpty() &&
                base.text.isEmpty() &&
                targetBase.text.isEmpty()
    }

    private fun validateNumber(num: String): String {
        var number = num
        // always make the number look like a real number
        number += if(number.indexOf('.') == -1) "." else ""
        number = number.toUpperCase()

        val pointCount = number.count { chr -> chr == '.'}
        return number.substring(0,
            if(pointCount == 1) number.length
            else number.lastIndexOf('.')
        )

    }

    private fun isBaseValid(base: Int): Boolean {

        return base != 1
    }
}
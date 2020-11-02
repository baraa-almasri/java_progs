package com.baraamasri.konverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun convert(view: View) {

        welcomeText.text = if(isNumberValid(number) &&
            isBaseValid(base) &&
            isBaseValid(targetBase))
            SuperConverter.convert(
            validateNumber( number.text.toString() ),
            base.text.toString().toInt(),
            targetBase.text.toString().toInt()
        ) else "Fill boxes correctly blyat!!"


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

    private fun isNumberValid(number: EditText): Boolean {

        return number.text.isNotEmpty()
    }

    private fun isBaseValid(base: EditText): Boolean {

        return base.text.isNotEmpty() && base.text.toString().toInt() > 1
    }

}
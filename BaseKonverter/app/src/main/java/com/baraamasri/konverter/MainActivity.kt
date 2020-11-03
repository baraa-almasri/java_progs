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

        welcomeText.text = if(number.text.isNotEmpty()  &&
            isBaseValid(base) &&
            isBaseValid(targetBase))
            SuperConverter.convert(
            validateNumber( number.text.toString() ),
            base.text.toString().toInt(),
            targetBase.text.toString().toInt()

        ) else "Fill boxes correctly blyat!!"

    }

    private fun validateNumber(number: String): String {

        return removeExtraDots(
            (removeGarbageInitials(number) +
                    // R ∋ x
                    if(number.indexOf('.') == -1) "."
                    else ""
                    ).toUpperCase()
        )
    }

    private fun removeGarbageInitials(number: String): String {
        var num = number
        num = removeInitialZeros(num)
        num = removeInitialDots(num)

        return if(isNumberValid(num)) num
        else removeGarbageInitials(num)
    }

    private fun removeExtraDots(number: String): String {

        return if(number.count { chr -> chr == '.'} == 1) number
            else removeExtraDots(
                number.substring(0, number.lastIndexOf('.'))
        )
    }

    private fun removeInitialZeros(number: String): String {

        return if(number[0] != '0') number
            else removeInitialZeros(number.substring(1,number.length - 1))
    }

    private fun removeInitialDots(number: String): String {

        return if(number[0] != '.') number
            else removeInitialDots(number.substring(1,number.length - 1))
    }

    private fun isNumberValid(number: String): Boolean {

        return number.isNotEmpty() &&
                number[0] != '.' &&
                number[0] != '0'
    }

    private fun isBaseValid(base: EditText): Boolean {

        return base.text.isNotEmpty() && base.text.toString().toInt() > 1
    }

}
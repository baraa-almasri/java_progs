package com.baraamasri.konverter

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
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

        try {
            welcomeText.text = if (isNumberValid(number) &&
                    isBaseValid(base) &&
                    isBaseValid(targetBase)

                ) removeInitialDots(
                    SuperConverter.convert(
                        validateNumber(number.text.toString()),
                        base.text.toString().toInt(),
                        targetBase.text.toString().toInt()
                    )
                ) else "Fill boxes correctly blyat!!"
        } catch(nfe: NumberFormatException) {
            welcomeText.text = "ENTER A CORRECT NUMBER!!"
        }

    }

    fun copyToCB(view: View) {
        val cb = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("Blyat", welcomeText.text.toString())
        cb.setPrimaryClip(clipData)

    }

    private fun validateNumber(number: String): String {

        return removeExtraDots(
            (removeInitialDots(number) +
                    // R ∋ x
                    if(number.indexOf('.') == -1) "."
                    else ""
                    ).toUpperCase()
        )
    }

    private fun removeExtraDots(number: String): String {

        return if(number.count { chr -> chr == '.'} == 1) number
        else removeExtraDots(
            number.substring(0, number.lastIndexOf('.'))
        )
    }

    private fun removeInitialDots(number: String): String {

        return if(number[0] != '.') number
        else "0$number"
    }

    private fun isNumberValid(number: EditText): Boolean {

        return number.text.toString().isNotEmpty()
    }

    private fun isBaseValid(base: EditText): Boolean {

        return base.text.isNotEmpty() && base.text.toString().toInt() > 1
    }

}
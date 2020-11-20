package com.baraamasri.morsetranslator

import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private var clipboard: ClipboardManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

        clearText.setOnLongClickListener {
            result.setText("Enter Message Blyat!")

            true
        }

        clearText.setOnClickListener {
            message.setText("")
        }
    }

    fun evaluate(view: View) {
        val morseCode = MorseCode()
        try {
            result.text = when (view.id) {
                R.id.encode -> (morseCode.encode(message.text.toString()))
                R.id.decode -> (morseCode.decode(message.text.toString()))
                else -> " "
            }

        } catch(e: Exception) {
            makeToast("Are you blind?")

            return
        }

        if(view.id == R.id.encode) {
            copyToCB(view)
        }

    }

    fun copyToCB(view: View) {
        clipboard!!.text = result.text
        makeToast("Copied to clipboard")
    }

    fun pasteFromCB(view: View) {
        message.setText(clipboard!!.text.toString())
        evaluate(decode)
        makeToast("Paste from clipboard")
    }

    private fun makeToast(str: String) {
        (Toast.makeText(applicationContext, str, Toast.LENGTH_SHORT)).show()
    }
}
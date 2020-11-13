package com.baraamasri.encoderblyat

import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

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

        result.text = (when(view.id) {
            R.id.encode -> (Encoder(message.text.toString()))
            R.id.decode -> (Decoder(message.text.toString()))
            else -> Any() as Crypt

        }).getProcessedMessage()

    }

    fun copyToCB(view: View) {
        clipboard!!.text = result.text
    }

    fun pasteFromCB(view: View) {
        message.setText(clipboard!!.text.toString())
    }

}
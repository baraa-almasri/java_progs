package com.baraamasri.encryptblyat

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun evaluate(view: View) {

        result.text = when(view.id) {

            R.id.encrypt -> {
                (Encoder(message.text.toString())).getMessage()
            }

            R.id.decrypt -> {
                (Decoder(message.text.toString())).getMessage()
            }

            else -> {""}
        }

    }

    fun copyToCB(view: View) {
        val cb = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        cb.setPrimaryClip( ClipData.newPlainText("Blyat", result.text.toString()) )
    }
}
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

        clearText.setOnLongClickListener(object: View.OnLongClickListener {
            override fun onLongClick(v: View?): Boolean {
                result.setText("Enter Message Blyat!")

                return true
            }
        })

        clearText.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                message.setText("")
            }
        })
    }

    fun evaluate(view: View) {

        result.text = (when(view.id) {
            R.id.encrypt -> (Encoder(message.text.toString()))
            R.id.decrypt -> (Decoder(message.text.toString()))
            else -> Any() as Crypt

        }).getProcessedMessage()

    }

    fun copyToCB(view: View) {
        val cb = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        cb.setPrimaryClip( ClipData.newPlainText("Blyat", result.text.toString()) )
    }

}
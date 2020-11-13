package com.baraamasri.encoderblyat

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.Base64

class Encoder(message: String): Crypt(message){

    @RequiresApi(Build.VERSION_CODES.O)
    override fun getProcessedMessage(): String {
        return Base64.getEncoder().encodeToString(
            this.encodeBlyat().toByteArray()
        )
    }

    private fun encodeBlyat(): String {
        var encodedMsg = ""
        for(chr: Char in this.message) {
            encodedMsg += (33..47).random().toChar().toString() +
                    (97..122).random().toChar().toString() +
                    Math.pow(chr.toDouble(), 2.0).toInt().toString()
        }

        return encodedMsg
    }
}

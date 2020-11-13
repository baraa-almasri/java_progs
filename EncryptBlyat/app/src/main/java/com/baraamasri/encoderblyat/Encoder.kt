package com.baraamasri.encoderblyat

import android.util.Base64

class Encoder(message: String): Crypt(message){

    override fun getProcessedMessage(): String {
        return Base64.encodeToString(
            this.encodeBlyat().toByteArray(), 0
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

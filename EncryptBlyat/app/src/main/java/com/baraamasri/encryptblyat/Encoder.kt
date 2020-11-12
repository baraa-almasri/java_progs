package com.baraamasri.encryptblyat

class Encoder(private var message: String) {

    fun getMessage(): String {
        return this.encodeBlyat()
    }

    private fun encodeBlyat(): String {
        var encodedMsg = ""
        for(chr: Char in this.message) {
            encodedMsg += ">=" + Math.pow(chr.toDouble(), 2.0).toInt().toString()
        }

        return encodedMsg
    }
}

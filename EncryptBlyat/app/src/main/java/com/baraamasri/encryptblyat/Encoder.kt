package com.baraamasri.encryptblyat

class Encoder(message: String): Crypt(message){

    override fun getProcessedMessage(): String {
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

package com.baraamasri.encoderblyat

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.Base64
import kotlin.collections.ArrayList


@RequiresApi(Build.VERSION_CODES.O)
class Decoder(message: String): Crypt(message) {
    private var entries: ArrayList<String>
    init {
        this.message = String(Base64.getDecoder().decode(
            message.toByteArray()
        )) + "0" // additional digit in order to get the last digit

        this.removeLowers()
        this.entries = ArrayList(0)
    }

    override fun getProcessedMessage(): String {
        this.updateEntries()

        return this.decodeBlyat()
    }

    private fun removeLowers() {
        this.message = this.message.replace("[a-z]".toRegex(), "")
    }

    private fun getGreaterThanIndecies(): ArrayList<Int> {
        var indeices = ArrayList<Int>()

        for((index, chr) in this.message.withIndex()) {
            if(!chr.isDigit()) {
                indeices.add(index)
            }
        }
        indeices.add(this.message.length - 1) // dont ask

        return indeices
    }

    private fun updateEntries() {
        val indices = this.getGreaterThanIndecies()

        for( index in 0 until indices.size - 1) {
            this.entries.add(
                    this.message.substring(
                            indices[index] + 1,
                            indices[index + 1]
                    )
            )
        }
    }

    private fun decodeBlyat(): String {
        var decodedMsg = ""
        for( e in this.entries ) {
            decodedMsg += (Math.sqrt(e.toDouble())).toInt().toChar() //chr (int(math.sqrt(int(e))))
        }

        return decodedMsg
    }

}
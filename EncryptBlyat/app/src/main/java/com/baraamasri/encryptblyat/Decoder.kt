package com.baraamasri.encryptblyat

import java.lang.Math

class Decoder(message: String) {
    private var entries: ArrayList<String>
    private var message: String
    init {
        this.message = message + " "
        this.removeEqualSigns()
        this.entries = ArrayList(0)
    }

    fun getMessage(): String {
        this.updateEntries()
        return this.decodeBlyat()
    }

    private fun removeEqualSigns() {
        this.message = this.message.replace("\\=".toRegex(), "")
    }

    private fun getGreaterThanIndecies(): ArrayList<Int> {
        var indeices = ArrayList<Int>()

        for((index, chr) in this.message.withIndex()) {
            if(chr == '>') {
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

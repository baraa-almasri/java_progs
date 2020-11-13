package com.baraamasri.encoderblyat

abstract class Crypt(protected var message: String) {
    
    abstract fun getProcessedMessage(): String
}
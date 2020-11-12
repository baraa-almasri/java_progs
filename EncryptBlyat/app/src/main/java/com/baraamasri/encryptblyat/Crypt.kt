package com.baraamasri.encryptblyat

import java.lang.Math

abstract class Crypt(protected var message: String) {
    
    abstract fun getProcessedMessage(): String
}
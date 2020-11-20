package com.baraamasri.morsetranslator

class MorseCode {
    private var morse: HashMap<Char, String>

    init {
        this.morse = HashMap()
        this.initMorseMap()
    }

    fun decode(message: String): String {
        var decodedMsg = ""
        val messageEntries = getEntries(message.replace("\\s\\s".toRegex(), " "))

        for(entry: String in messageEntries) {
            decodedMsg += this.getKey(entry)
        }

        return decodedMsg
    }

    fun encode(message: String): String {
        var encodedMsg = ""
        for(chr: Char in message.toUpperCase()) {
            encodedMsg += this.morse[chr] + ' '
        }

        return encodedMsg
    }

    private fun getEntries(message: String): ArrayList<String> {
        val spacesIndexes = getSpacesIndexes(" $message ")
        val entries = ArrayList<String>()
        for(index: Int in 0 until spacesIndexes.size - 1) {
            entries.add(
                    " $message ".substring(
                        spacesIndexes[index] + 1,
                        spacesIndexes[index+1]
                )
            )
        }

        return entries
    }

    private fun getSpacesIndexes(message: String): ArrayList<Int> {
        val spacesIndex = ArrayList<Int>()
        for((index, chr) in message.withIndex()) {
            if(chr == ' ') {
                spacesIndex.add(index)

            }
        }

        return spacesIndex
    }

    private fun getKey(value: String): Char {
        val keys = this.morse.keys
        for(k: Char in keys) {
            if(this.morse[k] == value ) {
                return k
            }
        }

        return ' '
    }

    private fun initMorseMap() {
        this.morse['A'] = ".-"
        this.morse['B'] = "-..."
        this.morse['C'] = "-.-."
        this.morse['D'] = "-.."
        this.morse['E'] = "."
        this.morse['F'] = "..-."
        this.morse['G'] = "--."
        this.morse['H'] = "...."
        this.morse['I'] = ".."
        this.morse['J'] = ".---"
        this.morse['K'] = "-.-"
        this.morse['L'] = ".-.."
        this.morse['M'] = "--"
        this.morse['N'] = "-."
        this.morse['O'] = "---"
        this.morse['P'] = ".--."
        this.morse['Q'] = "--.-"
        this.morse['R'] = ".-."
        this.morse['S'] = "..."
        this.morse['T'] = "-"
        this.morse['U'] = "..-"
        this.morse['V'] = "...-"
        this.morse['W'] = ".--"
        this.morse['X'] = "-..-"
        this.morse['Y'] = "-.--"
        this.morse['Z'] = "--.."
        this.morse['0'] = "-----"
        this.morse['1'] = ".----"
        this.morse['2'] = "..---"
        this.morse['3'] = "...--"
        this.morse['4'] = "....-"
        this.morse['5'] = "....."
        this.morse['6'] = "-...."
        this.morse['7'] = "--..."
        this.morse['8'] = "---.."
        this.morse['9'] = "----."
        this.morse[' '] = " "
        this.morse[','] = "..-.."
        this.morse['.'] = ".-.-.-"
        this.morse['?'] = "..--.."
        this.morse[';'] = "-.-.-"
        this.morse[':'] = "---..."
        this.morse['/'] = "-..-."
        this.morse['+'] = ".-.-."
        this.morse['-'] = "-....-"
        this.morse['='] = "-...-"
        this.morse['('] = "-.--.-"

    }
}
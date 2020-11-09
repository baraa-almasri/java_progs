package com.baraamasri.kalculator

import kotlin.math.pow

class InfixParser(expression: String) {

    var expression: String
    private var lastAnswer: Double
    private var entries: ArrayList<String>

    init {
        this.expression = " " + // so the evaluate function won't get confused
                if(checkExpression(expression)) expression else ""

        this.lastAnswer = 0.0
        this.entries = ArrayList(0)

    }

    fun evaluate(): Double {
        this.expression = this.expression.substring(0,
            if(this.expression[this.expression.length-1] == '.') this.expression.length-1
            else this.expression.length
        )
        this.updateEntries()
        for (i in 0 until this.entries.size) {
            if (isOperator(this.entries[i][0])) {
                this.lastAnswer = execOperator(
                    this.entries[i - 1].toDouble(),
                    this.entries[i + 1].toDouble(),
                    this.entries[i][0]
                )
                this.entries[i + 1] = this.lastAnswer.toString()

            }
        }
        this.expression = " $lastAnswer"
        this.entries.clear()

        return this.lastAnswer
    }

    fun addEntry(entry: String) {
        this.expression += if(checkExpression(entry)) entry else ""

    }

    private fun getSpacesIndexes(): ArrayList<Int> {
        val spacesIndex = ArrayList<Int>(0)
        for((index, chr) in this.expression.withIndex()) {
            if(chr == ' ') {
                spacesIndex.add(index)

            }
        }

        return spacesIndex
    }

    private fun updateEntries() {
        val spacesIndexes = getSpacesIndexes()
        for(index: Int in 0 until spacesIndexes.size - 1) {
            this.entries.add(
                this.expression.substring(
                    spacesIndexes[index] + 1,
                    spacesIndexes[index+1]
                )
            )
        }
    }

    private fun checkSameEquation(expression: String): Boolean {

        return false
    }

    private fun checkExpression(expression: String): Boolean {
        for(chr: Char in expression) {
            if(!isCharValid(chr)) {
                return false
            }
        }

        return true
    }

    private fun isCharValid(chr: Char): Boolean {

        return (
                !(chr.isLowerCase() && chr.isUpperCase()) &&
                        ( chr.isDigit() || isOperator(chr) || chr == ' '
                                || chr == '.'
                                )
                )
    }

    private fun execOperator
                (rightOperand: Double, leftOperand: Double, op: Char)
            : Double {

        return if(op == '+') rightOperand + leftOperand else
            if(op == '-') rightOperand - leftOperand else
                if(op == '*') rightOperand * leftOperand else
                    if(op == '/') rightOperand / leftOperand else
                        if(op == '^') rightOperand.pow(leftOperand) else 0.0
    }

    private fun isOperator(chr: Char): Boolean {

        return chr == '+' || chr == '-' ||
                chr == '*' || chr == '/' ||
                chr == '^'
    }

}

package com.baraamasri.kalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Button
import android.widget.Toast
import com.baraamasri.kalculator.parser.InfixParser
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    /*
     * Intro to the mess bellow:
     * addEntry: 1. adds an entry to the expression at the current cursor location or at the end
     *           2. if it's a number append it to the current number(or cursor place)
     *              and sets the `operatorExist` flag to false
     *           3. if it's an operator(and exists once) append a whitespace to the expression string then add the operator
     *              and sets the flags `numberHasFloatingPoint` to false, `operatorExist` to true
     *           4. if it's a floating point(and exists once) append it to the number
     *              and sets the flag `numberHasFloatingPoint` to true
     *
     * evaluate: evaluates the given infix expression and adds a whitespace to the beginning of it
     */

    private var expressionParser = InfixParser("")
    private var numberHasFloatingPoint = false
    private var operatorExist = false

    fun evaluate(view: View) {
        expressionParser.addEntry(" ")
        expressionParser.expression = removeInitialDots(expressionParser.expression)
        numberDisplay.setText(
                " ${expressionParser.evaluate()}"
        )
        numberHasFloatingPoint = true
        operatorExist = false
    }

    fun addEntry(butt: View) {
        butt as Button

        when {
            isNumber(butt.text.toString()) -> {
                expressionParser.expression = addToString(
                    expressionParser.expression,
                    butt.text.toString(),
                    if((numberDisplay.selectionStart - 1) > 0)
                        numberDisplay.selectionStart - 1
                    else numberDisplay.text.toString().length-1
                )
                operatorExist = false

            }
            butt.text.toString()[0] == '.' && !numberHasFloatingPoint -> {
                numberHasFloatingPoint = true

                expressionParser.expression = addToString(
                    expressionParser.expression,
                    butt.text.toString(),
                    if((numberDisplay.selectionStart - 1) > 0)
                        numberDisplay.selectionStart - 1
                    else numberDisplay.text.toString().length-1
                )
            }
            isOperator(butt.text.toString()) && !operatorExist -> {
                expressionParser.addEntry(
                    if(butt.text.toString() == "÷") " / " else " ${butt.text} "
                )
                numberHasFloatingPoint = false
                operatorExist = true

            }
        }

        numberDisplay.setText(expressionParser.expression)
    }

    fun clear(view: View) {
        operatorExist = false
        numberHasFloatingPoint = false
        expressionParser.expression = " "
        numberDisplay.setText("0")
    }

    fun makeToastNotReady(view: View) {
        val toast = Toast.makeText(applicationContext, "Not Ready Blyat!", Toast.LENGTH_SHORT)
        toast.show()
    }

    private fun addToString(str: String, middleShit: String, index: Int): String {

        return str.substring(0, index+1) + middleShit + str.substring(index+1)
    }

    private fun removeInitialDots(number: String): String {

        return number.replace(" [.]".toRegex(), "0.")
    }

    private fun isNumber(number: String): Boolean {
        try{
            number.toDouble()
        } catch(nfe: NumberFormatException) {
            return false
        }

        return true
    }

    private fun isOperator(chr: String): Boolean {
        val op = chr[0]
        try{
            chr[1]

        } catch(sioobe: StringIndexOutOfBoundsException) {
            return op == '+' || op == '-' ||
                    op == '*' || op == '/' ||
                    op == '^'

        }

        return false
    }

}
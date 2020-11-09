package com.baraamasri.kalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    private var expressionParser = InfixParser("")
    private var numberHasFloatingPoint = false
    private var operatorExist = false

    fun evaluate(view: View) {
        expressionParser.addEntry(" ")
        expressionParser.expression = removeInitialDots(expressionParser.expression)
        numberDisplay.setText(
                " ${expressionParser.evaluate()}"
        )
        operatorExist = false
    }

    fun addEntry(butt: View) {
        butt as Button

        when {
            butt.text.toString()[0].isDigit() -> {
                expressionParser.expression = addToString(
                    expressionParser.expression,
                    butt.text.toString(),
                    if((numberDisplay.selectionStart - 1) > 0)
                        numberDisplay.selectionStart - 1
                    else numberDisplay.text.toString().length-1
                )

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
            isOperator(butt.text.toString()[0]) && !operatorExist -> {
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

        return if(number[0] != '.') number
        else "0$number"
    }

    private fun isOperator(chr: Char): Boolean {

        return chr == '+' || chr == '-' ||
                chr == '*' || chr == '/' ||
                chr == '^' || chr == '÷'
    }

}
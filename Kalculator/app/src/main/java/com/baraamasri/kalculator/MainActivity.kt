package com.baraamasri.kalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Button
import android.widget.Toast
import ExpressionToolbox.*
import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager

fun Activity.hideKeyboard() {
    hideKeyboard(currentFocus ?: View(this))
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

class MainActivity : AppCompatActivity() {
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

    private lateinit var evaluator: InfixEvaluator
    private var expression = ""
    private var numberHasFloatingPoint = false
    private var operatorExist = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberDisplay.setOnClickListener {
            hideKeyboard()
        }

    }

    fun evaluate(view: View) {
        // TODO
        // catch WrongExpressionBlyat

        this.expression = removeInitialDots(this.expression)

        this.evaluator = InfixEvaluator(this.expression)
        val answer = evaluator.evaluate().toString()
        this.expression =
                answer.substring(0, if (answer.length > 7) 8 else answer.length)

        numberDisplay.setText(expression)
        numberHasFloatingPoint = true
        operatorExist = false
    }


    // TODO
    // separate when into functions blyat
    fun addEntry(view: View) {
        view as Button

        val entry = view.text.toString()
        val cursorLocation = numberDisplay.selectionStart

        when {
            TermChecker.isNumber(entry) -> {
                this.expression = addToString(
                    this.expression,
                    entry,
                    if (cursorLocation > 0)
                        cursorLocation-1
                    else numberDisplay.text.toString().length-1
                )
                operatorExist = false
                numberHasFloatingPoint = false
            }
            entry == "." && !numberHasFloatingPoint -> {
                numberHasFloatingPoint = true

                this.expression = addToString(
                    this.expression,
                    entry,
                    if (cursorLocation > 0)
                        cursorLocation-1
                    else numberDisplay.text.toString().length-1
                )
            }
            TermChecker.isOperator(entry) || entry == "÷"-> {
                this.expression = addToString(
                    this.expression,
                    if (entry == "÷") "/" else entry,
                    if (cursorLocation > 0)
                        cursorLocation-1
                    else numberDisplay.text.toString().length-1
                )

                numberHasFloatingPoint = false
            }
        }

        numberDisplay.setText(this.expression)
    }

    fun clear(view: View) {
        operatorExist = false
        numberHasFloatingPoint = false
        this.expression = ""
        numberDisplay.setText("")
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

}
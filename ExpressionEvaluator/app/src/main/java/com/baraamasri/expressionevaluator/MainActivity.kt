package com.baraamasri.expressionevaluator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_main.*
import com.baraamasri.expressionevaluator.parser.*
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var expressionType = ""
    fun selectExpressionType(view: View) {
        view as CheckBox

        when (view.id) {
            R.id.infixCheck -> {
                if(prefixCheck.isChecked) {
                    prefixCheck.toggle()
                }

                if(postfixCheck.isChecked) {
                    postfixCheck.toggle()
                }
            }
            R.id.postfixCheck -> {
                if(infixCheck.isChecked) {
                    infixCheck.toggle()
                }
                if(prefixCheck.isChecked) {
                    prefixCheck.toggle()
                }
            }
            R.id.prefixCheck -> {
                if(infixCheck.isChecked) {
                    infixCheck.toggle()
                }
                    if(postfixCheck.isChecked) {
                    postfixCheck.toggle()
                }
            }
            else -> {}
        }

        expressionType = view.text.toString()

    }

    fun evaluate(view: View) {
        val parser: Parser

        when (expressionType) {
            "Infix" -> {
                parser = InfixParser(expressionText.text.toString())
            }
            "Postfix" -> {
                parser = PostfixParser(expressionText.text.toString())
            }
            "Prefix" -> {
                parser = PrefixParser(expressionText.text.toString())
            }
            else -> {
                result.setText("Select expression type!")
                makeToastBlyat()
                return
            }
        }

        try {
            val answer = parser.evaluate()

            result.setText(
                if(answer == Double.MIN_VALUE )"Enter operators correctly!"
                else answer.toString()
            )

        } catch(oobe: IndexOutOfBoundsException) {
            result.setText("Select expression type correctly!")
            makeToastBlyat()
            return

        } catch(nfe: NumberFormatException) {
            result.setText("Enter number correctly!")
            makeToastBlyat()
            return
        }

    }

    fun makeToastBlyat() {
        (Toast.makeText(applicationContext, "блять!", Toast.LENGTH_SHORT)).show()
    }

}
package com.baraamasri.expressionevaluator

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var expressionEvaluator: Evaluator
    private var expressionType = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun selectExpressionType(view: View) {
        view as CheckBox

        when (view.id) {
            R.id.infixCheck -> {
                if (prefixCheck.isChecked) {
                    prefixCheck.toggle()
                }

                if (postfixCheck.isChecked) {
                    postfixCheck.toggle()
                }
            }
            R.id.postfixCheck -> {
                if (infixCheck.isChecked) {
                    infixCheck.toggle()
                }
                if (prefixCheck.isChecked) {
                    prefixCheck.toggle()
                }
            }
            R.id.prefixCheck -> {
                if (infixCheck.isChecked) {
                    infixCheck.toggle()
                }
                if (postfixCheck.isChecked) {
                    postfixCheck.toggle()
                }
            }
            else -> {
            }
        }

        expressionType = view.text.toString()

    }

    private fun setExpressionType() {
        when (expressionType) {
            "Infix" -> {
                expressionEvaluator = InfixEvaluator(expressionText.text.toString())
            }
            "Postfix" -> {
                expressionEvaluator = PostfixEvaluator(expressionText.text.toString())
            }
            "Prefix" -> {
                expressionEvaluator = PrefixEvaluator(expressionText.text.toString())
            }
            else -> {
                result.setText("Select expression type!")
                makeToastBlyat()
            }
        }
    }

    fun evaluate(view: View) {

        try {
            setExpressionType()

            result.setText(
                expressionEvaluator.evaluate().toString()
            )

        } catch (wre: WrongOperatorsException) {
            result.setText("What the hell was that!!")
            makeToastBlyat()

        } catch (nvee: NotValidExpressionException) {
            result.setText("Really?!")
            makeToastBlyat()
        }


    }

    fun makeToastBlyat() {
        (Toast.makeText(applicationContext, "блять!", Toast.LENGTH_SHORT)).show()
    }

}
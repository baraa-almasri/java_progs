package com.baraamasri.expressionevaluator

import ExpressionToolbox.*
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // for cleaner expression selection
    enum class ExpressionType {
        INFIX,
        PREFIX,
        POSTFIX,
        NON
    }

    private var expressionEvaluator: Evaluator? = null
    private var expressionType = ExpressionType.NON

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun selectInfix(view: View) {
        view as CheckBox

        if (prefixCheck.isChecked) {
            prefixCheck.toggle()
        }

        if (postfixCheck.isChecked) {
            postfixCheck.toggle()
        }


        this.expressionType = ExpressionType.INFIX
    }

    fun selectPostfix(view: View) {
        view as CheckBox

        if (infixCheck.isChecked) {
            infixCheck.toggle()
        }
        if (prefixCheck.isChecked) {
            prefixCheck.toggle()
        }

        this.expressionType = ExpressionType.POSTFIX
    }

    fun selectPrefix(view: View) {
        view as CheckBox

        if (infixCheck.isChecked) {
            infixCheck.toggle()
        }
        if (postfixCheck.isChecked) {
            postfixCheck.toggle()
        }

        this.expressionType = ExpressionType.PREFIX
    }

    fun evaluate(view: View) {
        try {
            setExpressionType()

            if (this.expressionEvaluator != null) {
                result.setText(
                    expressionEvaluator?.evaluate().toString()
                )
            }
        } catch (wre: WrongOperatorsException) {
            result.setText("What the hell was that!!")
            makeToastBlyat()

        } catch (nvee: NotValidExpressionException) {
            result.setText("Really?!")
            makeToastBlyat()
        }

    }

    private fun makeToastBlyat() {
        (Toast.makeText(applicationContext, "блять!", Toast.LENGTH_SHORT)).show()
    }

    private fun setExpressionType() {
        this.expressionEvaluator = when (expressionType) {
            ExpressionType.INFIX -> {
                InfixEvaluator(expressionText.text.toString())
            }
            ExpressionType.POSTFIX -> {
                PostfixEvaluator(expressionText.text.toString())
            }
            ExpressionType.PREFIX -> {
                PrefixEvaluator(expressionText.text.toString())
            }
            else -> {
                null
            }
        }
    }

}
package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.iterator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    fun initButtonsColors() {

        row1.e11.text = ""
        row1.e12.text = ""
        row1.e13.text = ""

        row2.e21.text = ""
        row2.e22.text = ""
        row2.e23.text = ""

        row3.e31.text = ""
        row3.e32.text = ""
        row3.e33.text = ""

        for( button in row1 ) {
            button.setBackgroundColor(0xff000000.toInt())
        }

        for( button in row2 ) {
            button.setBackgroundColor(0xff000000.toInt())
        }

        for( button in row3 ) {
            button.setBackgroundColor(0xff000000.toInt())
        }

    }

    fun updateGame(ttt: TicTacToe) {

        if(ttt.checkIfMapIsFull()) {
            initButtonsColors()
            ttt.resetMap()
        }
        when(ttt.checkMap()) {
            2 -> {
                xScore.text = "X: " + scoreX++.toString()
                ttt.resetMap()
                initButtonsColors()
                }
            1 -> {
                oScore.text = "O: " + scoreO++.toString()
                ttt.resetMap()
                initButtonsColors()
                }
            }

    }

    private var scoreX = 0
    private var scoreO = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initButtonsColors()

        var uGame = TicTacToe
        /*
         * player flag:
         * x: false
         * 0: true
         */
        var bCurrentPlayer = true

        row1.e11.setOnClickListener {
            updateGame(uGame)
            if (uGame.getMapValue(0) == 0) {
                uGame.setMapValue(0, if(bCurrentPlayer) 2 else 1 )
                bCurrentPlayer = !bCurrentPlayer

                row1.e11.text = if (bCurrentPlayer) "O" else "X"
                row1.e11.setBackgroundColor(if(bCurrentPlayer) 0xffe91e63.toInt() else 0xff4caf50.toInt())

            }
        }

        row1.e12.setOnClickListener {
            updateGame(uGame)
            if (uGame.getMapValue(1) == 0) {
                uGame.setMapValue(1, if(bCurrentPlayer) 2 else 1 )
                bCurrentPlayer = !bCurrentPlayer


                row1.e12.text = if (bCurrentPlayer) "O" else "X"
                row1.e12.setBackgroundColor(if(bCurrentPlayer) 0xffe91e63.toInt() else 0xff4caf50.toInt())
            }
        }

        row1.e13.setOnClickListener {
            updateGame(uGame)
            if (uGame.getMapValue(2) == 0) {
                uGame.setMapValue(2, if(bCurrentPlayer) 2 else 1 )
                bCurrentPlayer = !bCurrentPlayer


                row1.e13.text = if (bCurrentPlayer) "O" else "X"
                row1.e13.setBackgroundColor(if(bCurrentPlayer) 0xffe91e63.toInt() else 0xff4caf50.toInt())
            }
        }

        row2.e21.setOnClickListener {
            updateGame(uGame)
            if (uGame.getMapValue(3) == 0) {
                uGame.setMapValue(3, if(bCurrentPlayer) 2 else 1 )
                bCurrentPlayer = !bCurrentPlayer

                row2.e21.text = if (bCurrentPlayer) "O" else "X"
                row2.e21.setBackgroundColor(if(bCurrentPlayer) 0xffe91e63.toInt() else 0xff4caf50.toInt())
            }
        }

        row2.e22.setOnClickListener {
            updateGame(uGame)
            if (uGame.getMapValue(4) == 0) {
                uGame.setMapValue(4, if(bCurrentPlayer) 2 else 1 )
                bCurrentPlayer = !bCurrentPlayer


                row2.e22.text = if (bCurrentPlayer) "O" else "X"
                row2.e22.setBackgroundColor(if(bCurrentPlayer) 0xffe91e63.toInt() else 0xff4caf50.toInt())
            }
        }

        row2.e23.setOnClickListener {
            updateGame(uGame)
            if (uGame.getMapValue(5) == 0) {
                uGame.setMapValue(5, if(bCurrentPlayer) 2 else 1 )
                bCurrentPlayer = !bCurrentPlayer


                row2.e23.text = if (bCurrentPlayer) "O" else "X"
                row2.e23.setBackgroundColor(if(bCurrentPlayer) 0xffe91e63.toInt() else 0xff4caf50.toInt())
            }
        }

        row3.e31.setOnClickListener {
            updateGame(uGame)
            if (uGame.getMapValue(6) == 0) {
                uGame.setMapValue(6, if(bCurrentPlayer) 2 else 1 )
                bCurrentPlayer = !bCurrentPlayer


                row3.e31.text = if (bCurrentPlayer) "O" else "X"
                row3.e31.setBackgroundColor(if(bCurrentPlayer) 0xffe91e63.toInt() else 0xff4caf50.toInt())
            }
        }

        row3.e32.setOnClickListener {
            updateGame(uGame)
            if (uGame.getMapValue(7) == 0) {
                uGame.setMapValue(7, if(bCurrentPlayer) 2 else 1 )
                bCurrentPlayer = !bCurrentPlayer

                row3.e32.text = if (bCurrentPlayer) "O" else "X"
                row3.e32.setBackgroundColor(if(bCurrentPlayer) 0xffe91e63.toInt() else 0xff4caf50.toInt())
            }
        }

        row3.e33.setOnClickListener {
            updateGame(uGame)
            if (uGame.getMapValue(8) == 0) {
                uGame.setMapValue(8, if(bCurrentPlayer) 2 else 1 )
                bCurrentPlayer = !bCurrentPlayer


                row3.e33.text = if (bCurrentPlayer) "O" else "X"
                row3.e33.setBackgroundColor(if(bCurrentPlayer) 0xffe91e63.toInt() else 0xff4caf50.toInt())
            }
        }


    }


}
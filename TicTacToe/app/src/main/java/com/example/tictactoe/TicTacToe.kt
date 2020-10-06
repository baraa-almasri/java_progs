package com.example.tictactoe

object TicTacToe {

    fun resetMap(): Boolean {
        //if( this.checkIfMapIsFull() ) {

            var it = 0
            while( it < this.gameMap.size) {
                this.gameMap[it] = 0

                it++
            }

            return true
        //}

        return false
    }

    fun checkMap(): Int { // Int: who scored

        return when {
            this.checkColumns() > 0 -> this.checkColumns()
            this.checkRows() > 0 -> this.checkRows()
            this.checkDiagonals() > 0 -> this.checkDiagonals()
            else -> 0
        }

    }

    fun setMapValue(location: Int, value: Int) {
        this.gameMap[location] = value

    }

    fun getMapValue(location: Int): Int {

        return this.gameMap[location]
    }

// private attributes
    /*
     * gameMap values:
     * 0: empty cell
     * 1: x flag
     * 2: o flag
     */
    private var gameMap = Array<Int>(9){0}

    /*private var playerX = Player()
    private var playerO = Player()
*/
// private methods
     fun checkIfMapIsFull(): Boolean {

        for( element: Int in this.gameMap ) {
            if( element == 0 ) {
                return false
            }
        }

        return true
    }

    private fun checkRows(): Int {
        var it = 0

        while (it < this.gameMap.size) {
            // check winner
            if(this.gameMap[it + 0] == 1 &&
                    this.gameMap[it + 1] == 1 &&
                    this.gameMap[it + 2] == 1) {

                return 1;
            }
            else if(this.gameMap[it + 0] == 2 &&
                    this.gameMap[it + 1] == 2 &&
                    this.gameMap[it + 2] == 2){

                return 2
            }

            it += 3
        }

        return 0
    }

    private fun checkColumns(): Int {
        var it = 0

        while (it < 3) {

            // check winner
            if(this.gameMap[it + 0] == 1 &&
                this.gameMap[it + 3] == 1 &&
                this.gameMap[it + 6] == 1) {

                return 1;
            }
            else if(this.gameMap[it + 0] == 2 &&
                    this.gameMap[it + 3] == 2 &&
                    this.gameMap[it + 6] == 2){

                return 2
            }

            it++
        }

        return 0
    }


    private fun checkDiagonals(): Int {

        return if(this.gameMap[0] == 1 &&
                this.gameMap[4] == 1 &&
                this.gameMap[8] == 1) 1
        else if (this.gameMap[6] == 1 &&
                this.gameMap[4] == 1 &&
                this.gameMap[2] == 1) 1
        else if(this.gameMap[0] == 2 &&
                this.gameMap[4] == 2 &&
                this.gameMap[8] == 2) 2
        else if (this.gameMap[6] == 2 &&
                this.gameMap[4] == 2 &&
                this.gameMap[2] == 2) 2
        else 0


    }

}
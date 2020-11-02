import SeperatedNumber
import kotlin.text.StringBuilder
import kotlin.math.pow

object SuperConverter {

    // BIG FAT NOTE ABOUT THIS CLASS!!
    // numbers are passed as strings, because of bases > 10

    fun convert(number: String, numberBase: Int, targetBase: Int): String {

        // ok this one is a bit messy
        // first check if the number is valid according to its base
        // if valid, check if the number's base is 10 if so
        // convert it to the target base provided, if not 10
        // convert it to 10, then the target base
        // if the number is invalid return the message "IDI NAHUI"
        // which is kinda of an error code :)
        return if( isNumberValid(number, numberBase) )
            convert0( if(numberBase == 10) number else
            convert0(number, numberBase, 10),
            10, targetBase)
            else "IDI NAHUI!!"
    }


    private fun convert0(number: String, numberBase: Int, targetBase: Int): String {
        val num = SeperatedNumber(number)
        var finalNumber = ""

        // converting number pre floating point
        finalNumber += (if(numberBase == 10)
        SuperConverter::convertPrePointFromDecimal else
        SuperConverter::convertPrePointToDecimal

        )(num.getPrePoint(), if(numberBase == 10) targetBase else numberBase)

        // add floating point(if exists)
        finalNumber += (
                if(num.getPointIndex() == -1) (48).toChar() else '.'
        )

        // converting number after floating point
        finalNumber += (if(numberBase == 10)
            SuperConverter::convertPostPointFromDecimal else
            SuperConverter::convertPostPointToDecimal

        )(num.getPostPoint(), if(numberBase == 10) targetBase else numberBase)

        // if the number was zero a weird string will be produced! so....
        return when {
            finalNumber == ".0" -> "0.0"
            num.isNegative() -> "-$finalNumber" // also if the number is negative respect that!
            else -> finalNumber
        }
    }


// more private level 1:

    private fun isNumberValid(number: String, numberBase: Int): Boolean {
        for(digit: Char in number) {
            if( digit.toInt() - (if(numberBase > 9) 55 else 48) >= numberBase) {

                return false
            }
        }

        return true;
    }

// more private level 2:

    // before decimal point
    private fun convertPrePointFromDecimal(sPrePoint: String, base: Long): String {
        var prePoint = sPrePoint.toLong()

        var finalNumber = ""

        while(prePoint != 0L) {
            finalNumber += (
                (
                    (if(prePoint % base > 9) 55 else 48)
                    + (prePoint % base)
                ).toChar()
            )

            prePoint /= base;
        }

        return StringBuilder(finalNumber).reverse().toString()
    }

    // after decimal point
    private fun convertPostPointFromDecimal(sPostPoint: String, base: Long): String {
        var finalNumber = ""

        val number = SeperatedNumber(sPostPoint)
        var prePointOfResult: Int
        var postPoint = number.getPostPoint().toDouble()
        val initPostPoint = postPoint

        do {

            postPoint *= base

            prePointOfResult = (postPoint % (if (base > 9) 100 else 10)).toInt()

            finalNumber += (
                (
                    (if(prePointOfResult % base > 9) 55 else 48) // ascii code for CAPS or number
                    + (prePointOfResult % base) // how much ascii
                ).toChar()
            )

            postPoint -= prePointOfResult

        } while(( initPostPoint != postPoint )
        && postPoint >= 0.099)

        return finalNumber
    }

    /* convert to decimal as this formula
     * ∑ n[i]*(base)^i
     * where digits before decimal point have 0 based indexes
     * and after the point have indexes starting with -1 then -2 ....
     * 
    */

    // before decimal point
    private fun convertPrePointToDecimal(prePoint0: String, base: Int): String {
        val prePoint = StringBuilder(prePoint0).reverse().toString()

        var convertedPrePoint = 0L
        // TODO
        // Roll loop in a reverse order
        for(index in prePoint.indices) {
            convertedPrePoint += ( (prePoint[index] -
                    (if(prePoint[index].toInt() > 64) 55 else 48 ) ).toInt()
             * base.toDouble().pow(index.toDouble())).toLong()

        }

        return convertedPrePoint.toString()
    }

    // after decimal point
    private fun convertPostPointToDecimal(postPoint: String, base: Int): String {
        var convertedPostPoint = 0.0;
        for(index in 2 until postPoint.length) {
            // k-1 beacuase index started at 2 where point was at index 1 LOL
            convertedPostPoint += ( (postPoint[index] - (if(postPoint[index].toInt() > 64) 55 else 48 )).toInt()
            * base.toDouble().pow((-1 * (index - 1)).toDouble()))

        }

        // only the fractional part :)
        return convertedPostPoint.toString().substring(2)
    }


};

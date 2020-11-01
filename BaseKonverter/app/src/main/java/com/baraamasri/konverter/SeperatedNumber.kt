class SeperatedNumber(number0: String) {
    private var prePoint: String
    private var postPoint: String
    private var pointIndex: Int
    private var negative: Boolean

    init {
        this.negative = number0[0] == '-'
        val number = if(this.negative) number0.substring(1, number0.length - 1) else number0
        this.pointIndex = number.indexOf('.')
        this.prePoint = number.substring(0, if(this.pointIndex == -1) number.length else this.pointIndex)
        this.postPoint = "0" + if(this.pointIndex == -1) "0" else number.substring(this.pointIndex, number.length )
    }

    fun getPrePoint(): String {

        return this.prePoint
    }

    fun getPostPoint(): String {

        return this.postPoint
    }

    fun getPointIndex(): Int {

        return this.pointIndex
    }

    fun isNegative(): Boolean {

        return this.negative
    }

    fun getNumber(): String {

        return this.prePoint + "." + if(this.pointIndex > -1) "0" else this.postPoint
    }

}


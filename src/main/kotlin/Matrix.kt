class Matrix(private val x : List<DoubleArray>) {

    companion object {
        fun createMatrix(x : List<DoubleArray>): Matrix {
            val temp = x[0].size
            for (i in x) {
                if (i.size != temp) throw IllegalArgumentException(("all rows must be of identical size!"))
            }
            return Matrix(x)
        }

        fun createVector(x: List<DoubleArray>): Matrix {
            if (x.size !=3) throw IllegalArgumentException("Vector must contain exactly 3 rows")
            for (i in x) if (i.size != 1) throw IllegalArgumentException("Vector must contain 3 rows of one value")
            return Matrix(x)
        }

        fun createVector(x: DoubleArray): Matrix {
            if (x.size != 3) throw IllegalArgumentException("Vector must contain exactly 3 rows")
            return Matrix(listOf(
                doubleArrayOf(x[0]),
                doubleArrayOf(x[1]),
                doubleArrayOf(x[2])
            ))
        }
    }

    operator fun times(other: Matrix): Matrix {
        require(this.getCols() == other.getRows())
        val result = List(this.getRows()) { DoubleArray(other.getCols()) }
        for (i in 0 until this.getRows()) {
            for (j in 0 until other.getCols()) {
                for (k in 0 until other.getRows()) {
                    result[i][j] += this.x[i][k] * other.x[k][j]
                }
            }
        }
        return Matrix(result)
    }

    fun print() {
        for (element in x) println(element.joinToString(", "))
    }

    private fun getRows(): Int = x.size
    private fun getCols(): Int = x[0].size
}
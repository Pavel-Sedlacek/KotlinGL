class Matrix(private val x : List<DoubleArray>) {

    private var rows = x.size
    private var cols = x[0].size

    companion object {
        fun createMatrix(x : List<DoubleArray>): Matrix {
            val temp = x[0].size
            for (i in x)
                if (i.size != temp) throw IllegalArgumentException(("all rows must be of identical size!"))
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
        require(this.cols == other.rows)
        val result = List(this.rows) { DoubleArray(other.cols) }
        for (i in 0 until this.rows) {
            for (j in 0 until other.cols) {
                for (k in 0 until other.rows) {
                    result[i][j] += this.x[i][k] * other.x[k][j]
                }
            }
        }
        return Matrix(result)
    }

    fun print() {
        for (element in x) println(element.joinToString(", "))
    }
}
import kotlin.doubleArrayOf as row

fun main() {
    val m1 = Matrix.createMatrix(
        listOf(
            row(1.0, 0.0, 0.0),
            row(0.0, 1.0, 0.0),
            row(0.0, 0.0, 1.0)
        )
    )

    val v1 = Matrix.createVector(
        row(1.0, 2.0, 1.0)
    )

    (m1 * v1).print()
    1.times(2)
}
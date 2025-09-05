opaque type Matrix = (array: Array[Int], cols: Int)
object Matrix:
  def apply(rows: Int, cols: Int): Matrix = (Array.fill(rows * cols)(0), cols)
end Matrix

extension (matrix: Matrix)
  def get(row: Int, col: Int): Int = matrix.array(row * matrix.cols + col)

def main(): Unit =
  val matrix = Matrix(3, 3)
  matrix
  //
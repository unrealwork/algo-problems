package com.hackerrank.fp.introduction.integral

object Integral {
  // This function will be used while invoking "Summation" to compute
  // The area under the curve.
  def f(coefficients: List[Int], powers: List[Int], x: Double): Double = {
    (for ((c, p) <- coefficients.zip(powers))
      yield Math.pow(x, p) * c)
      .sum
  }

  // This function will be used while invoking "Summation" to compute
  // The Volume of revolution of the curve around the X-Axis
  // The 'Area' referred to here is the area of the circle obtained
  // By rotating the point on the curve (x,f(x)) around the X-Axis
  def area(coefficients: List[Int], powers: List[Int], x: Double): Double = {
    Math.PI * Math.pow(f(coefficients, powers, x), 2)
  }

  // This is the part where the series is summed up
  // This function is invoked once with func = f to compute the area         // under the curve
  // Then it is invoked again with func = area to compute the volume
  // of revolution of the curve
  def summation(func: (List[Int], List[Int], Double) => Double, upperLimit: Int, lowerLimit: Int, coefficients: List[Int], powers: List[Int]): Double = {
    def summationAcc(x: Double, resAcc: Double, count: Int): Double = {
      val H = 1e-3
      if (x > upperLimit) {
        resAcc
      } else {
        summationAcc(x + H, resAcc + func(coefficients, powers, x) * H, count +1)
      }
    }

    summationAcc(lowerLimit, 0, 0)
  }


  // The Input-Output functions will be handled by us. You only need to concentrate your effort on the function bodies above.

}

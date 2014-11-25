package laff.ch1

import breeze.linalg._

object vect_lab_2 {

  // ------ Summing vectors ------//
  
  val x = DenseVector(4, -3)                      //> x  : breeze.linalg.DenseVector[Int] = DenseVector(4, -3)
  val y = DenseVector(1, 5)                       //> y  : breeze.linalg.DenseVector[Int] = DenseVector(1, 5)
  val z = x + y                                   //> z  : breeze.linalg.DenseVector[Int] = DenseVector(5, 2)
  y + x                                           //> res0: breeze.linalg.DenseVector[Int] = DenseVector(5, 2)
}
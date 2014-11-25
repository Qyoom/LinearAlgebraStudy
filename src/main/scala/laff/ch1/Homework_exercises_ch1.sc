package laff.ch1

import breeze.linalg._

object Homework_exercises_ch1 {
	// 1.3.1.1
  val p1 = DenseVector(1, -1, 2)                  //> p1  : breeze.linalg.DenseVector[Int] = DenseVector(1, -1, 2)
  val p2 = DenseVector(0, 0, 0)                   //> p2  : breeze.linalg.DenseVector[Int] = DenseVector(0, 0, 0)
  val p3 = DenseVector(1, 1, -2)                  //> p3  : breeze.linalg.DenseVector[Int] = DenseVector(1, 1, -2)
  val p4 = DenseVector(0, 2, -4)                  //> p4  : breeze.linalg.DenseVector[Int] = DenseVector(0, 2, -4)
  
  val v1 = p2 - p1                                //> v1  : breeze.linalg.DenseVector[Int] = DenseVector(-1, 1, -2)
  val v2 = p3 - p4                                //> v2  : breeze.linalg.DenseVector[Int] = DenseVector(1, -1, 2)
  v1 == v2                                        //> res0: Boolean = false
  
  // 1.3.2.1
  DenseVector(-1, 2) + DenseVector(-3, -2)        //> res1: breeze.linalg.DenseVector[Int] = DenseVector(-4, 0)
  // 1.3.2.2
  DenseVector(-3, -2) + DenseVector(-1, 2)        //> res2: breeze.linalg.DenseVector[Int] = DenseVector(-4, 0)
  // 1.3.2.4
  DenseVector(-1, 2) + DenseVector(-3, -2) + DenseVector(1, 2)
                                                  //> res3: breeze.linalg.DenseVector[Int] = DenseVector(-3, 2)
  DenseVector(1,2,3) + DenseVector.zeros[Int](3)  //> res4: breeze.linalg.DenseVector[Int] = DenseVector(1, 2, 3)

	// 1.3.3.1
	DenseVector(-1,2) + DenseVector(-1,2) + DenseVector(-1,2)
                                                  //> res5: breeze.linalg.DenseVector[Int] = DenseVector(-3, 6)
  DenseVector(-1,2) * 3                           //> res6: breeze.linalg.DenseVector[Int] = DenseVector(-3, 6)
}
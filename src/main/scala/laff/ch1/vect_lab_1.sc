package laff.ch1

import breeze.linalg._
 
object vect_lab_1 {
  val x1 = DenseVector(1,2)                       //> x1  : breeze.linalg.DenseVector[Int] = DenseVector(1, 2)
  val x2 = DenseVector(1,2)                       //> x2  : breeze.linalg.DenseVector[Int] = DenseVector(1, 2)
  val x3 = DenseVector(2,4)                       //> x3  : breeze.linalg.DenseVector[Int] = DenseVector(2, 4)
  val x4 = DenseVector(2,1)                       //> x4  : breeze.linalg.DenseVector[Int] = DenseVector(2, 1)
  val x5 = DenseVector(1,2,3)                     //> x5  : breeze.linalg.DenseVector[Int] = DenseVector(1, 2, 3)
  val x6 = DenseVector(1,2,4)                     //> x6  : breeze.linalg.DenseVector[Int] = DenseVector(1, 2, 4)
	val x7 = DenseVector(1,2,4)               //> x7  : breeze.linalg.DenseVector[Int] = DenseVector(1, 2, 4)
  
  // ---- Equality ------------------ //
  
  x1 == x2                                        //> res0: Boolean = true
  (x1 :== x2).toArray                             //> res1: Array[Boolean] = Array(true, true)
  x1 == x3                                        //> res2: Boolean = false
  x5 == x6                                        //> res3: Boolean = false
  (x5 :== x6).toArray                             //> res4: Array[Boolean] = Array(true, true, false)
  x6 == x7                                        //> res5: Boolean = true
  (x6 :== x7).toArray                             //> res6: Array[Boolean] = Array(true, true, true)
  
  // ---- Copying -------------------//
  
  val x8 = x7 // BOTH POINTING TO SAME OBJECT! This is not a copy!
                                                  //> x8  : breeze.linalg.DenseVector[Int] = DenseVector(1, 2, 4)
  x7(0) = 3
  x7                                              //> res7: breeze.linalg.DenseVector[Int] = DenseVector(3, 2, 4)
  x8                                              //> res8: breeze.linalg.DenseVector[Int] = DenseVector(3, 2, 4)
  x8(1) = 5
  x7                                              //> res9: breeze.linalg.DenseVector[Int] = DenseVector(3, 5, 4)
  
  // This works in terms of copying the values of one Vector into another
  val x9 = DenseVector(x5.toArray)                //> x9  : breeze.linalg.DenseVector[Int] = DenseVector(1, 2, 3)
  x5(0) = 4
  x5                                              //> res10: breeze.linalg.DenseVector[Int] = DenseVector(4, 2, 3)
  x9                                              //> res11: breeze.linalg.DenseVector[Int] = DenseVector(1, 2, 3)
  
  // Elementwise copy
  val x10 = DenseVector.zeros[Int](x5.length)     //> x10  : breeze.linalg.DenseVector[Int] = DenseVector(0, 0, 0)
  x10 := x5                                       //> res12: breeze.linalg.DenseVector[Int] = DenseVector(4, 2, 3)
  x10                                             //> res13: breeze.linalg.DenseVector[Int] = DenseVector(4, 2, 3)
  x5(2) = 5
  x5                                              //> res14: breeze.linalg.DenseVector[Int] = DenseVector(4, 2, 5)
  x10                                             //> res15: breeze.linalg.DenseVector[Int] = DenseVector(4, 2, 3)
  x9                                              //> res16: breeze.linalg.DenseVector[Int] = DenseVector(1, 2, 3)
  
  //----- Addition, Subtraction, Scaling ---------------//
  
  x1 + x1                                         //> res17: breeze.linalg.DenseVector[Int] = DenseVector(2, 4)
  x1 * 2                                          //> res18: breeze.linalg.DenseVector[Int] = DenseVector(2, 4)
  
  val x11 = DenseVector(4.0, -3.0)                //> x11  : breeze.linalg.DenseVector[Double] = DenseVector(4.0, -3.0)
  x11 + x11                                       //> Nov 25, 2014 2:09:56 PM com.github.fommil.jni.JniLoader liberalLoad
                                                  //| INFO: successfully loaded /var/folders/qk/q84p77h56y371pyw0vp69j1h0000gn/T/j
                                                  //| niloader8704467823575439455netlib-native_system-osx-x86_64.jnilib
                                                  //| res19: breeze.linalg.DenseVector[Double] = DenseVector(8.0, -6.0)
  val alpha = -(1.0/2)                            //> alpha  : Double = -0.5
  val y = x11 * alpha                             //> y  : breeze.linalg.DenseVector[Double] = DenseVector(-2.0, 1.5)
  x11 := x11 * alpha                              //> res20: breeze.linalg.DenseVector[Double] = DenseVector(-2.0, 1.5)
  y == x11                                        //> res21: Boolean = true
  (y :== x11).toArray                             //> res22: Array[Boolean] = Array(true, true)
  
  val x12 = DenseVector(-1, 2)                    //> x12  : breeze.linalg.DenseVector[Int] = DenseVector(-1, 2)
  x12 + x12 + x12                                 //> res23: breeze.linalg.DenseVector[Int] = DenseVector(-3, 6)
  //3 * x12 // Error
  x12 * 3                                         //> res24: breeze.linalg.DenseVector[Int] = DenseVector(-3, 6)
  
  val x13 = DenseVector(7, -3)                    //> x13  : breeze.linalg.DenseVector[Int] = DenseVector(7, -3)
  val x14 = DenseVector(5, 2)                     //> x14  : breeze.linalg.DenseVector[Int] = DenseVector(5, 2)
  x13 + x14                                       //> res25: breeze.linalg.DenseVector[Int] = DenseVector(12, -1)
  x13 - x14                                       //> res26: breeze.linalg.DenseVector[Int] = DenseVector(2, -5)
  x14 - x13                                       //> res27: breeze.linalg.DenseVector[Int] = DenseVector(-2, 5)
  x14 - x14                                       //> res28: breeze.linalg.DenseVector[Int] = DenseVector(0, 0)
  x1 - x1                                         //> res29: breeze.linalg.DenseVector[Int] = DenseVector(0, 0)
  
  x5                                              //> res30: breeze.linalg.DenseVector[Int] = DenseVector(4, 2, 5)
  x6                                              //> res31: breeze.linalg.DenseVector[Int] = DenseVector(1, 2, 4)
  val x15 = x5 + x6                               //> x15  : breeze.linalg.DenseVector[Int] = DenseVector(5, 4, 9)
  
  // -------- Product ----------------------------- //
  
  val v1 = DenseVector(3,5,7,2,8,3)               //> v1  : breeze.linalg.DenseVector[Int] = DenseVector(3, 5, 7, 2, 8, 3)
  val v2 = DenseVector(2,4,3,7,9,1)               //> v2  : breeze.linalg.DenseVector[Int] = DenseVector(2, 4, 3, 7, 9, 1)
  val v3 = DenseVector(3,4,2)                     //> v3  : breeze.linalg.DenseVector[Int] = DenseVector(3, 4, 2)
  
  // element-wise multiplication
  val prod1 = v1 :* v2                            //> prod1  : breeze.linalg.DenseVector[Int] = DenseVector(6, 20, 21, 14, 72, 3)
                                                  //| 
  prod1.sum                                       //> res32: Int = 136
  
  // dot product
  val prod4 = v1 dot v2                           //> prod4  : Int = 136
  
  //val prod5 = v1.t dot v2 error
  
  // Error if lengths don't match
  //val prod2 = v1:*v3 // error
  //val prod3 = v1 dot v3 // error
  //v1.t * v3 // error
}
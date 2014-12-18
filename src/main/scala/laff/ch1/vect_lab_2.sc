package laff.ch1

import breeze.linalg._

object vect_lab_2 {

  // ------ Summing vectors ------//
  
  val x = DenseVector(4d, -3d)                    //> x  : breeze.linalg.DenseVector[Double] = DenseVector(4.0, -3.0)
  val y = DenseVector(1d, 5d)                     //> y  : breeze.linalg.DenseVector[Double] = DenseVector(1.0, 5.0)
  val z = x + y                                   //> Nov 25, 2014 11:06:50 AM com.github.fommil.jni.JniLoader liberalLoad
                                                  //| INFO: successfully loaded /var/folders/qk/q84p77h56y371pyw0vp69j1h0000gn/T/j
                                                  //| niloader1843404523997337694netlib-native_system-osx-x86_64.jnilib
                                                  //| z  : breeze.linalg.DenseVector[Double] = DenseVector(5.0, 2.0)
  y + x                                           //> res0: breeze.linalg.DenseVector[Double] = DenseVector(5.0, 2.0)
  
  // ----- AXPY -----------------//
  // y := ax + y
  val y1 = x*2d + y                               //> y1  : breeze.linalg.DenseVector[Double] = DenseVector(9.0, -1.0)
  val y2 = x*.02 + y                              //> y2  : breeze.linalg.DenseVector[Double] = DenseVector(1.08, 4.94)

	// ----- Weirdness
  (-3)*2                                          //> res1: Int(-6) = -6
  //-3*2 // error!!
  -(3*2)                                          //> res2: Int = -6
}
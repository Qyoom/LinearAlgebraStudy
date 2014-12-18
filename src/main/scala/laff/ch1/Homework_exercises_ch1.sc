package laff.ch1

import breeze.linalg._
import math._

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
  
  // 1.3.4.1
  p1 - p1                                         //> res7: breeze.linalg.DenseVector[Int] = DenseVector(0, 0, 0)
  
  // 1.4.2.3
  val v3 = DenseVector[Double](1,0,0)             //> v3  : breeze.linalg.DenseVector[Double] = DenseVector(1.0, 0.0, 0.0)
  val v4 = DenseVector[Double](0,1,0)             //> v4  : breeze.linalg.DenseVector[Double] = DenseVector(0.0, 1.0, 0.0)
  val v5 = DenseVector[Double](0,0,1)             //> v5  : breeze.linalg.DenseVector[Double] = DenseVector(0.0, 0.0, 1.0)
  val alpha = 2d                                  //> alpha  : Double = 2.0
  val beta = -1d                                  //> beta  : Double = -1.0
  val gamma = 3d                                  //> gamma  : Double = 3.0
  v3*alpha + v4*beta + v5*gamma                   //> Dec 07, 2014 10:28:41 PM com.github.fommil.jni.JniLoader liberalLoad
                                                  //| INFO: successfully loaded /var/folders/qk/q84p77h56y371pyw0vp69j1h0000gn/T/j
                                                  //| niloader4715527795434264021netlib-native_system-osx-x86_64.jnilib
                                                  //| res8: breeze.linalg.DenseVector[Double] = DenseVector(2.0, -1.0, 3.0)
  // 1.4.3.2 - 1.4.3.12
  val fourOnes = DenseVector(1,1,1,1)             //> fourOnes  : breeze.linalg.DenseVector[Int] = DenseVector(1, 1, 1, 1)
  val v6 = DenseVector(2,5,-6,1)                  //> v6  : breeze.linalg.DenseVector[Int] = DenseVector(2, 5, -6, 1)
  val v7 = DenseVector(1,2,3,4)                   //> v7  : breeze.linalg.DenseVector[Int] = DenseVector(1, 2, 3, 4)
  val v8 = DenseVector(1,0,0,2)                   //> v8  : breeze.linalg.DenseVector[Int] = DenseVector(1, 0, 0, 2)
  
  fourOnes dot v6                                 //> res9: Int = 2
  v6 dot fourOnes                                 //> res10: Int = 2
  v6 + v7                                         //> res11: breeze.linalg.DenseVector[Int] = DenseVector(3, 7, -3, 5)
  v6 dot v7                                       //> res12: Int = -2
  v6 :* v7                                        //> res13: breeze.linalg.DenseVector[Int] = DenseVector(2, 10, -18, 4)
  fourOnes dot (v6 + v7)                          //> res14: Int = 12
  (v6 + v7).sum                                   //> res15: Int = 12
  v6.sum + v7.sum                                 //> res16: Int = 12
  (fourOnes dot v6) + (fourOnes dot v7)           //> res17: Int = 12
  v6 + (v8 dot v7)                                //> res18: breeze.linalg.DenseVector[Int] = DenseVector(11, 14, 3, 10)
  (v6 + v7) dot (v6 + v7)                         //> res19: Int = 92
  (v6 dot v6) + 2*(v6 dot v7) + (v7 dot v7)       //> res20: Int = 92
  
  val v9 = DenseVector(1,-2)                      //> v9  : breeze.linalg.DenseVector[Int] = DenseVector(1, -2)
  val v10 = DenseVector(0,0)                      //> v10  : breeze.linalg.DenseVector[Int] = DenseVector(0, 0)
  val v11 = DenseVector(2,1)                      //> v11  : breeze.linalg.DenseVector[Int] = DenseVector(2, 1)
  
  v9 dot v10                                      //> res21: Int = 0
  v9 dot v11                                      //> res22: Int = 0
  
  // 1.4.4.1
  def euclideanLength(v: DenseVector[Double]): Double = {
  		val vSqrElems = v.map(x => pow(x,2))
  		sqrt(vSqrElems.sum)
  }                                               //> euclideanLength: (v: breeze.linalg.DenseVector[Double])Double
  
  euclideanLength(DenseVector(0d,0d,0d))          //> res23: Double = 0.0
  euclideanLength(DenseVector(1/2d,1/2d,1/2d,1/2d))
                                                  //> res24: Double = 1.0
  euclideanLength(DenseVector(1d,-2,2))           //> res25: Double = 3.0
  euclideanLength(DenseVector(0d,0,1,0,0))        //> res26: Double = 1.0
  euclideanLength(DenseVector(sqrt(2)/2, sqrt(2)/2))
                                                  //> res27: Double = 1.0
  
  norm(DenseVector(0d,0d,0d))                     //> res28: Double = 0.0
  norm(DenseVector(1/2d,1/2d,1/2d,1/2d))          //> res29: Double = 1.0
  norm(DenseVector(1d,-2,2))                      //> res30: Double = 3.0
  norm(DenseVector(0d,0,1,0,0))                   //> res31: Double = 1.0
  norm(DenseVector(sqrt(2)/2, sqrt(2)/2))         //> res32: Double = 1.0
}
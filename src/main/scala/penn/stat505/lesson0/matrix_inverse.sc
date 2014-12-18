package penn.stat505.lesson0
import breeze.linalg._
import breeze.numerics._

object matrix_inverse {
  val A = new DenseMatrix[Double](2,2, Array(10d,8,6,5))
                                                  //> A  : breeze.linalg.DenseMatrix[Double] = 10.0  6.0  
                                                  //| 8.0   5.0  
  println("\nA:\n" + A + "\n")                    //> 
                                                  //| A:
                                                  //| 10.0  6.0  
                                                  //| 8.0   5.0  
                                                  //| 

  
  val A_inv = new DenseMatrix(2,2, Array(2.5, -4, -3, 5))
                                                  //> A_inv  : breeze.linalg.DenseMatrix[Double] = 2.5   -3.0  
                                                  //| -4.0  5.0   
  
  println("\nA_inv:\n" + A_inv + "\n")            //> 
                                                  //| A_inv:
                                                  //| 2.5   -3.0  
                                                  //| -4.0  5.0   
                                                  //| 
  println("\ninv(A):\n" + inv(A) + "\n")          //> Dec 17, 2014 4:03:08 PM com.github.fommil.jni.JniLoader liberalLoad
                                                  //| INFO: successfully loaded /var/folders/qk/q84p77h56y371pyw0vp69j1h0000gn/T/j
                                                  //| niloader370453324217584398netlib-native_system-osx-x86_64.jnilib
                                                  //| 
                                                  //| inv(A):
                                                  //| 2.5000000000000093  -3.000000000000011  
                                                  //| -4.000000000000014  5.000000000000018   
                                                  //| 
  // Can't figure out how to make round play nice yet!
  println("\ninv(A):\n" + round(inv(A)) + "\n")   //> 
                                                  //| inv(A):
                                                  //| 3   -3  
                                                  //| -4  5   
                                                  //| 
  A * inv(A)                                      //> Dec 17, 2014 4:03:08 PM com.github.fommil.jni.JniLoader load
                                                  //| INFO: already loaded netlib-native_system-osx-x86_64.jnilib
                                                  //| res0: breeze.linalg.DenseMatrix[Double] = 1.000000000000007      -3.55271367
                                                  //| 8800501E-15  
                                                  //| 3.552713678800501E-15  1.0                     
  // Note: round is suspect (see above)
  println("\nA * inv(A):\n" + round(A * inv(A)) + "\n")
                                                  //> 
                                                  //| A * inv(A):
                                                  //| 1  0  
                                                  //| 0  1  
                                                  //| 
  
  A * A_inv                                       //> res1: breeze.linalg.DenseMatrix[Double] = 1.0  0.0  
                                                  //| 0.0  1.0  
  println("\nA * A_inv = eye:\n" + (A * A_inv) + "\n")
                                                  //> 
                                                  //| A * A_inv = eye:
                                                  //| 1.0  0.0  
                                                  //| 0.0  1.0  
                                                  //| 
  val B = new DenseMatrix(4,2, Array(3,2,3,1,6,5,7,8))
                                                  //> B  : breeze.linalg.DenseMatrix[Int] = 3  6  
                                                  //| 2  5  
                                                  //| 3  7  
                                                  //| 1  8  
  println("\nB:\n" + B + "\n")                    //> 
                                                  //| B:
                                                  //| 3  6  
                                                  //| 2  5  
                                                  //| 3  7  
                                                  //| 1  8  
                                                  //| 
  println("\nB.t:\n" + B.t + "\n")                //> 
                                                  //| B.t:
                                                  //| 3  2  3  1  
                                                  //| 6  5  7  8  
                                                  //| 
  val D = DenseMatrix.rand(3, 3)                  //> D  : breeze.linalg.DenseMatrix[Double] = 0.7043243192334372  0.1084506470681
                                                  //| 2413  0.05612018825754972  
                                                  //| 0.6648479683090509  0.3237379324112901   0.634720014851615    
                                                  //| 0.5863562196119898  0.19084315432983967  0.09141347692150315  
  println("\nD:\n" + D + "\n")                    //> 
                                                  //| D:
                                                  //| 0.7043243192334372  0.10845064706812413  0.05612018825754972  
                                                  //| 0.6648479683090509  0.3237379324112901   0.634720014851615    
                                                  //| 0.5863562196119898  0.19084315432983967  0.09141347692150315  
                                                  //| 
  val C = DenseMatrix.eye[Double](3)              //> C  : breeze.linalg.DenseMatrix[Double] = 1.0  0.0  0.0  
                                                  //| 0.0  1.0  0.0  
                                                  //| 0.0  0.0  1.0  
  
  println("\nC:\n" + C + "\n")                    //> 
                                                  //| C:
                                                  //| 1.0  0.0  0.0  
                                                  //| 0.0  1.0  0.0  
                                                  //| 0.0  0.0  1.0  
                                                  //| 
  D * C == D                                      //> res2: Boolean = true
  C * D == D                                      //> res3: Boolean = true
  D.t * C == D                                    //> res4: Boolean = false
  D.t * C == D.t                                  //> res5: Boolean = true
}
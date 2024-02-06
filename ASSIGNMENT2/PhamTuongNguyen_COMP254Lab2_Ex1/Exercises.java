/**
 * Author: Pham Tuong Nguyen
 * ID: 30128505
 * Assignment 2 - Algorithm Analysis
 * Exercise 1
 */

class Exercises {

  /** Returns the sum of the integers in given array. */
  public static int example1(int[] arr) {
    int n = arr.length, total = 0; // constant time
    for (int j=0; j < n; j++)      // loop from 0 to n-1 
      total += arr[j]; 
    return total;
  }
  /** Example 1:
   * Time complexity: O(n)
   * Explanation: Because the function has a single for loop that iterates n times, 
   * where n is the length of the input array arr. 
   * The running time is linearly proportional to the size of the input array 
   */



  /** Returns the sum of the integers with even index in given array. */
  public static int example2(int[] arr) {
    int n = arr.length, total = 0;
    for (int j=0; j < n; j += 2)    // note the increment of 2
      total += arr[j];
    return total;
  }
  /** Example 2:
   * Time complexity: O(n)
   * Explanation: Because the function has a single for loop that iterates n/2 times,
   * where n is the length of the input array arr.
   * However, n/2 is even indexes, so the running time is still considered 
   * as a linear proportion to the size of the input array 
   */


  /** Returns the sum of the prefix sums of given array. */
  public static int example3(int[] arr) {
    int n = arr.length, total = 0;
    for (int j=0; j < n; j++)       // loop from 0 to n-1
      for (int k=0; k <= j; k++)    // loop from 0 to j
        total += arr[j];
    return total;
  }
  /** Example 3:
   * Time complexity: O(n^2)
   * Explanation: Because the function has a nested for loop that iterates n times in the outer loop,
   * and iterates j times in the inner loop, where j is the value of the outer loop.
   * Time complexity of outer loop is O(n), and the inner loop is O(n), so the total time complexity is n*n = n^2 
   */


  /** Returns the sum of the prefix sums of given array. */
  public static int example4(int[] arr) {
    int n = arr.length, prefix = 0, total = 0;
    for (int j=0; j < n; j++) {     // loop from 0 to n-1
      prefix += arr[j];
      total += prefix;
    }
    return total;
  }
  /** Example 4:
   * Time complexity: O(n)
   * Explanation: Because the function has a single for loop that iterates n times,
   * where n is the length of the input array arr.
   * The number of operations performed in each iteration is constant time O(1), 
   * this does not affect the total time complexity.
   * The running time is linearly proportional to the size of the input array 
   */


  /** Returns the number of times second array stores sum of prefix sums from first. */
  public static int example5(int[] first, int[] second) { // assume equal-length arrays
    int n = first.length, count = 0;
    for (int i=0; i < n; i++) {     // loop from 0 to n-1
      int total = 0;
      for (int j=0; j < n; j++)     // loop from 0 to n-1
        for (int k=0; k <= j; k++)  // loop from 0 to j
          total += first[k];
      if (second[i] == total) count++;
    }
    return count;
  }
  /** Example 5:
   * Time complexity: O(n^3)
   * Explanation: Because the function includes three nested for loops,
   * Each of the loops has a time complexity of O(n), 
   * Outer loop is O(n), the middle loop is O(n), and the inner loop is O(n).
   * The total time complexity is n*n*n = n^3
   */
}

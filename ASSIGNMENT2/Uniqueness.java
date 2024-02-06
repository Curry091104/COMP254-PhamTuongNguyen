/**
 * Author: Pham Tuong Nguyen
 * ID: 30128505
 * Assignment 2 - Algorithm Analysis
 * Exercise 3
 */

import java.util.Arrays;

class Uniqueness {

  /** Returns true if there are no duplicate elements in the array. */
  public static boolean unique1(int[] data) {
    int n = data.length;
    for (int j=0; j < n-1; j++) 
      for (int k=j+1; k < n; k++) 
        if (data[j] == data[k])
          return false;                    // found duplicate pair
    return true;                           // if we reach this, elements are unique
  }

  /** Returns true if there are no duplicate elements in the array. */
  public static boolean unique2(int[] data) {
    int n = data.length;
    int[] temp = Arrays.copyOf(data, n);   // make copy of data
    Arrays.sort(temp);                     // and sort the copy
    for (int j=0; j < n-1; j++)
      if (temp[j] == temp[j+1])            // check neighboring entries
        return false;                      // found duplicate pair
    return true;                           // if we reach this, elements are unique
  }

  public static void main(String[] args) {
    int max = 1000000;
    int min = 0;
    long start;
    long end;
    long duration;

    //Test Unique1
    while(min <= max){
      int mid = (min + max) / 2;
      int[] data = new int[mid];
      for (int i = 0; i < mid; i++) {
        data[i] = i;
      }
      start = System.currentTimeMillis();
      unique1(data);
      end = System.currentTimeMillis();
      duration = end - start;
      System.out.println("Unique1 with " + mid + " elements has run " + duration + " ms");

      if(duration > 1000){
        max = mid - 1;
      } else {
        min = mid + 1;
      }
    }
    System.out.println("Unique1 finished, max input size: " + max + "\n");
    System.out.println("=> In one minute, Unique1 can handle " + (max * 60000)/1000 + " elements" + "\n");

    //Test Unique2
    min = 0;
    max = 1000000;
    while(min <= max){
      int mid = (min + max) / 2;
      int[] data = new int[mid];
      for (int i = 0; i < mid; i++) {
        data[i] = i;
      }
      start = System.currentTimeMillis();
      unique2(data);
      end = System.currentTimeMillis();
      duration = end - start;
      System.out.println("Unique2 with " + mid + " elements has run " + duration + " ms");

      if(duration > 1000){
        max = mid - 1;
      } else {
        min = mid + 1;
      }
    }
    System.out.println("Unique2 finished, max input size: " + max + "\n");
    System.out.println("=> In one minute, Unique2 can handle " + ((long)max * 60000)/1000 + " elements" + "\n");
  }
}

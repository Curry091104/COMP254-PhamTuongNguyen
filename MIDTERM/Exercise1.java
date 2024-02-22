public class Exercise1{
    public static int maxElement(int[] A, int n){
        if(n==0) return A[n];
        return Math.max(A[n], maxElement(A, n-1));
    }
    //Running time of this function is linear time, it based on the size of the array 
}
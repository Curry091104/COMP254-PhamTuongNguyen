public class Exercise3 {
    public static int[] tenLargestElements(int[] A){
        int[] result = new int[10];
        int[] indices = new int[10];
        for(int i = 0; i < 10; i++){
            indices[i] = -1;
        } // running time of this loop is constant time because it is not based on the size of the array
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < 10; j++){
                if(indices[j] == -1 || A[i] > A[indices[j]]){
                    for(int k = 9; k > j; k--){
                        indices[k] = indices[k-1];
                    }
                    indices[j] = i;
                    break;
                }
            }
        }
        for(int i = 0; i < 10; i++){
            result[i] = A[indices[i]];
        }
        return result;
    }

    // => running time of this function is linear time 
}

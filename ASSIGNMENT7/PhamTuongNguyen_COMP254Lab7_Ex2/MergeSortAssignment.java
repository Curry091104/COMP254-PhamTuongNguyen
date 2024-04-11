import java.util.Comparator;

public class MergeSortAssignment {

    public static void main(String[] args) {
        // Create a queue list with unordered numbers
        Queue<Integer> Q = new LinkedQueue<>();
        Q.enqueue(15);
        Q.enqueue(23);
        Q.enqueue(13);
        Q.enqueue(44);
        Q.enqueue(35);
        Q.enqueue(66);
        Q.enqueue(57);
        Q.enqueue(88);
        Q.enqueue(29);
        System.out.println("Unsorted Queue: " + Q);
        Comparator<Integer> comp = new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i1.compareTo(i2);
            }
        };

        mergeSort(Q, comp);
        System.out.println("Sorted Queue: " + Q);
    }

    // bottom-up merge-sort of queues
    public static <K> void mergeSort(Queue<K> S, Comparator<K> comp) {
        int n = S.size();
        if (n < 2) return;
        Queue<Queue<K>> queues = new LinkedQueue<>();

        for (int i = 0; i < n; i++) {
            Queue<K> queue = new LinkedQueue<>();
            queue.enqueue(S.dequeue());
            queues.enqueue(queue);
        }

        while (queues.size() > 1) {
            Queue<K> q1 = queues.dequeue();
            Queue<K> q2 = queues.dequeue();
            Queue<K> merged = merge(q1, q2, comp);
            queues.enqueue(merged);
        }

        while(!S.isEmpty()){
            S.dequeue();
        }
        while(!queues.isEmpty()){
            Queue<K> q = queues.dequeue();
            while(!q.isEmpty()){
                S.enqueue(q.dequeue());
            }
        
        }
    }
    
    private static <K> Queue<K> merge(Queue<K> q1, Queue<K> q2, Comparator<K> comp) {
        Queue<K> merged = new LinkedQueue<>();
        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (comp.compare(q1.first(), q2.first()) < 0) {
                merged.enqueue(q1.dequeue());
            } else {
                merged.enqueue(q2.dequeue());
            }
        }

        while (!q1.isEmpty()) {
            merged.enqueue(q1.dequeue());
        }

        while (!q2.isEmpty()) {
            merged.enqueue(q2.dequeue());
        }
        return merged;
    }
}

package PhamTuongNguyen_COMP254Lab5_Ex3;

import SampleCode.Heap.AbstractPriorityQueue;
import SampleCode.Heap.Entry;

import java.util.ArrayList;
import java.util.Comparator;

public class Heap<K,V> extends AbstractPriorityQueue<K,V> {
    protected ArrayList<Entry<K,V>> heap = new ArrayList<>();
    public Heap() { super(); }
    public Heap(Comparator<K> comp) { super(comp); }

    protected int parent(int j) { return (j-1) / 2; }

    protected void swap(int pIndex, int cIndex){
        Entry<K,V> temp = heap.get(pIndex);
        heap.set(pIndex, heap.get(cIndex));
        heap.set(cIndex, temp);
    }
    protected void upheapAssigned(int c){
        int p = parent(c);
        if(compare(heap.get(c), heap.get(p)) >=0 ) return;
        swap(p,c);
        upheapAssigned(p);
    }
    protected void downheap(int c) { }

    @Override
    public int size() { return heap.size(); }

    @Override
    public Entry<K,V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);      // auxiliary key-checking method (could throw exception)
        Entry<K,V> newest = new PQEntry<>(key, value);
        heap.add(newest);                      // add to the end of the list
        upheapAssigned(heap.size() - 1);        // upheap newly added entry
        return newest;
    }

    @Override
    public Entry<K,V> min() {
        if (heap.isEmpty()) return null;
        return heap.get(0);
    }

    @Override
    public Entry<K,V> removeMin() {
        return null;
    }

    public static void main(String[] args) {
        Heap<String,String> heapQueue = new Heap<String,String>();
        heapQueue.insert("47", "A");
        heapQueue.insert("75", "C");
        heapQueue.insert("28", "B");
        heapQueue.insert("51", "D");
        heapQueue.insert("31", "F");
        heapQueue.insert("22", "G");
        heapQueue.insert("15", "H");

        // list all entries
        for (int i=0;i < heapQueue.size();i++)
            System.out.println("(" +heapQueue.heap.get(i).getKey() + ", " + heapQueue.heap.get(i).getValue() + ")" );
    }
}

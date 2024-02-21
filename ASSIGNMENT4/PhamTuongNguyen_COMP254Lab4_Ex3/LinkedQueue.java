package PhamTuongNguyen_COMP254Lab4_Ex3;

public class LinkedQueue<E> implements Queue<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();   // an empty  list
    public LinkedQueue() { }                  // new queue relies on the initially empty list
    @Override
    public int size() { return list.size(); }
    @Override
    public boolean isEmpty() { return list.isEmpty(); }
    @Override
    public void enqueue(E element) { list.addLast(element); }
    @Override
    public E first() { return list.first(); }

    @Override
    public E dequeue() { return list.removeFirst(); }
    public String toString() {
      return list.toString();
    }

    public void concatenate(LinkedQueue<E> Q2) {
        list.concatenate(Q2.list);
    }
    public static void main(String[] args) {
        LinkedQueue<String> Q1 = new LinkedQueue<>();
        Q1.enqueue("A");
        Q1.enqueue("B");
        Q1.enqueue("C");
        LinkedQueue<String> Q2 = new LinkedQueue<>();
        Q2.enqueue("X");
        Q2.enqueue("Y");
        Q2.enqueue("Z");
        Q1.concatenate(Q2);
        System.out.println(Q1);
    }
}
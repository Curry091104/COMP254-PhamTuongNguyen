package PhamTuongNguyen_COMP254Lab4_Ex3;

public interface Queue<E> {
    int size();
    boolean isEmpty();
    void enqueue(E e);
    E first();
    E dequeue();
  }

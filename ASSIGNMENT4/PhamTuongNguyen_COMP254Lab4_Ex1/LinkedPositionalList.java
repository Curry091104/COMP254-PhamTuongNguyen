package PhamTuongNguyen_COMP254Lab4_Ex1;

interface Position<E>{
    E getElement() throws IllegalStateException;
}
interface PositionalList<E> {
    int size();
    boolean isEmpty();
    Position<E> addFirst(E e);
    Position<E> addLast(E e);
}

public class LinkedPositionalList<E> implements PositionalList<E>{
    private static class Node<E> implements Position<E>{
        private E element;
        private Node<E> prev;
        private Node<E> next;
        public Node(){
            element = null;
            this.prev = null;
            this.next = null;
        }

        public Node(Node<E> prev, E e, Node<E> next){
            element = e;
            this.prev = prev;
            this.next = next;
        }
        public E getElement() throws IllegalStateException{
            if(next == null){
                throw new IllegalStateException("Position no longer valid");
            }
            return element;
        }
        public Node<E> getPrev(){
            return prev;
        }
        public Node<E> getNext(){
            return next;
        }
        public void setElement(E e){
            element = e;
        }
        public void setPrev(Node<E> prev){
            this.prev = prev;
        }
        public void setNext(Node<E> next){
            this.next = next;
        }
    }
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;
    public LinkedPositionalList(){
        header = new Node<>();
        trailer = new Node<>();
        header.setNext(trailer);
        trailer.setPrev(header);
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public Position<E> addBetween(E e, Node<E> before, Node<E> after){
        Node<E> newNode = new Node<>(before, e, after);
        before.setNext(newNode);
        after.setPrev(newNode);
        size++;
        return newNode;
    }
    public Position<E> addFirst(E e){
        return addBetween(e, header, header.getNext());
    }
    public Position<E> addLast(E e) {
        return addBetween(e, trailer.getPrev(), trailer);
    }
    public int indexOf(Position<E> p){
        int index = 0;
        Node<E> current = header.getNext();
        while(current != null) {
            if (current.getElement().equals(p.getElement())) {
                return index;
            }
            index++;
            current = current.getNext();
        }
        return -1;
    }

    public static void main(String[] args) {
        LinkedPositionalList<String> myList = new LinkedPositionalList<>();

        // Adding elements to the list
        Position<String> pos1 = myList.addFirst("A");
        Position<String> pos2 = myList.addLast("B");
        Position<String> pos3 = myList.addLast("C");

        try{
            System.out.println(myList.indexOf(pos1));
        } catch(Exception e){
            e.getMessage();
        }
    }
}

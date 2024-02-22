public class Exercise2 {
    public void reverse(SinglyLinkedList list){
        Node<E> prev = null;
        Node<E> current = head;
        while(current != null){
            Node<E> temp = current.getNext();
            current.setNext(prev);
            prev = current;
            current = temp;
        }
        head = current;
        tail = prev;
    }
}

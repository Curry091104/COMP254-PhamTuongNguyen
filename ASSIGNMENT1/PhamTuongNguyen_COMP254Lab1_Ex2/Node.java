package PhamTuongNguyen_COMP254Lab1_Ex2;

public class Node {
    private Node next;
    private Object data;

    Node(Object data, Node next){
        this.data = data;
        this.next = next;
    }

    public Object getElement() {return data;}
    public Node getNext() {return next;}
    public void setNext(Node next) {this.next = next;}

}

package PhamTuongNguyen_COMP254Lab1_Ex2;

public class Node {
    private Node prev;
    private Node next;
    private Object data;

    Node(Object data, Node next){
        this.data = data;
        this.next = next;
    }
    Node(Node prev, Object data, Node next){
        this.prev = prev;
        this.data = data;
        this.next = next;
    }

    public Object getElement() {return data;}
    public Node getPrev() {return prev;}
    public void setPrev(Node prev) {this.prev = prev;}
    public Node getNext() {return next;}
    public void setNext(Node next) {this.next = next;}

}

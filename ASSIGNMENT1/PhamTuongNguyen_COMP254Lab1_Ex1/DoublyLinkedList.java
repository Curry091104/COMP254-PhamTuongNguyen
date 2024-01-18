package PhamTuongNguyen_COMP254Lab1_Ex1;

public class DoublyLinkedList {
    //Main
    public static void main(String[] args){
        DoublyLinkedList M = new DoublyLinkedList();
        DoublyLinkedList L = new DoublyLinkedList();
        M.addLast(1);
        M.addLast(2);
        System.out.print("List M: ");
        M.display();
        System.out.println();

        L.addFirst(3);
        L.addLast(4);
        System.out.print("List L: ");
        L.display();
        System.out.println();

        System.out.println("After concatenating");
        M.concatenate(L); // the end of L concatenated to the beginning of M
        M.display();
    }
    private Node header;
    private Node trailer;
    private int size;
    public int size(){return size;}
    public boolean isEmpty(){return size == 0;}
    public void concatenate(DoublyLinkedList L){ 
        this.trailer.setNext(L.header);
        L.header.setPrev(this.trailer);
    }
    public void addFirst(Object data){
        Node newNode = new Node(null, data, null);
        if(isEmpty()){
            header = newNode;
            trailer = newNode;
        }
        else{
            newNode.setNext(header);
            header.setPrev(newNode);
            header = newNode;
        }
        size++;
    }
    public void addLast(Object data){
        Node newNode = new Node(null, data, null);
        if(isEmpty()){
            trailer = newNode;
            header = newNode;
        }
        else{
            newNode.setPrev(trailer);
            trailer.setNext(newNode);
            trailer = newNode;
        }
        size++;
    }
    public void display() {
        try{
            Node current = header;
            while (current != null) {
                System.out.print(current.getElement() + " ");
                current = current.getNext();
            }
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}


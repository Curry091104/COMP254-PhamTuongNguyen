package PhamTuongNguyen_COMP254Lab1_Ex1;

public class DoublyLinkedList {
    //Test harness
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

        //DoublyLinkedList newList = concatenate(M, L);
        //newList.display();
    }
    private Node header;
    private Node trailer;
    private int size;
    public int size(){return size;}
    public boolean isEmpty(){return size == 0;}
    public void concatenate(DoublyLinkedList L){ 
        this.trailer.setNext(L.header);
        L.header.setPrev(this.trailer);
        this.trailer = L.trailer;
        this.size += L.size;
    }


    // Another solution
    // public static DoublyLinkedList concatenate(DoublyLinkedList first, DoublyLinkedList second){
    //     DoublyLinkedList concatenateList = first;
    //     concatenateList.trailer.setNext(second.header);
    //     second.header.setPrev(concatenateList.trailer);
    //     concatenateList.trailer = second.trailer;
    //     concatenateList.size += second.size;
    //     return concatenateList;
    // }
    //Node class
    class Node{
        private Node prev;
        private Node next;
        private Object data;

        Node(Object data){
            this.prev = null;
            this.data = data;
            this.next = null;
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
    //------------------------------------------------
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


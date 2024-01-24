package PhamTuongNguyen_COMP254Lab1_Ex3;

class CircularlyLinkedList{
    //Test harness
    public static void main(String[] args){
        CircularlyLinkedList myList = new CircularlyLinkedList();

        myList.addLast(1);
        myList.addLast(2);
        myList.addLast(3);
        System.out.print("Initial list: ");
        myList.displayList();


        System.out.print("\nAfter clone: ");
        try{
            CircularlyLinkedList cloneList = myList.clone();
            cloneList.displayList();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    //Node class
    class Node{
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
    //------------------------------------------------

    private Node tail;
    private int size;
    public int size(){return size;}
    public boolean isEmpty(){return size == 0;}
    public CircularlyLinkedList clone() throws CloneNotSupportedException{
        CircularlyLinkedList newList = new CircularlyLinkedList();
        if (!isEmpty()) {
            Node walk = tail.getNext();
            Node currentNew = new Node(walk.getElement(), walk); 
            newList.tail = currentNew;
            newList.size++;
    
            while (walk != tail) {
                walk = walk.getNext();
                currentNew.setNext(walk);
                currentNew = currentNew.getNext();
                newList.size++;
            }
            newList.tail = currentNew;
        }
        return newList;
    }
    
    public Node first(){
        if(isEmpty()){
            return null;
        }
        if(size == 1){
            return tail;
        }
        else {
            return tail.getNext();
        }
    }
    public Node last(){
        if(isEmpty()){
            return null;
        }
        else {
            return tail;
        }
    }
    public void addFirst(Object data){
        if(isEmpty()){
            tail = new Node(data, null);
            tail.setNext(tail);
        }
        else{
            Node newNode = new Node(data, tail.getNext());
            tail.setNext(newNode);
        }
        size++;
    }
    public void addLast(Object data){
        if(isEmpty()){
            tail = new Node(data, null);
            tail.setNext(tail);
        }
        else{
            Node newNode = new Node(data, tail.getNext());
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }
    public Object removeFirst(){
        if(isEmpty()){
            return null;
        }
        Node head = tail.getNext();
        if(tail == head){
            tail = null;
        }
        else{
            tail.setNext(head.getNext());
        }
        size--;
        return head.getElement();
    }
    public void rotate(){
        if(tail != null) {
            tail = tail.getNext();
        }
    }

    //function display list
    public void displayList() {
        try{
            Node current = tail.getNext(); //tail.getNext() is the head of the list in circularly linked list
            do {
                System.out.print(current.getElement() + " ");
                current = current.getNext();
            } while (current != tail.getNext());
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
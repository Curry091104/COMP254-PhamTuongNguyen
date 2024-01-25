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
        
        Node(Object data){
            this.data = data;
            this.next = null;
        }

        Node(Object data, Node next){
            this.data = data;
            this.next = next;
        }
    
        public Object getData() {return data;}
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
            Node head = tail.getNext();
            Node headNew = new Node(head.getData());
            headNew.setNext(headNew);
            newList.tail = headNew;
            newList.size++;
            Node current = head;
            Node currentNew = headNew;
            while(current != tail){
                current = current.getNext();
                Node other = new Node(current.getData());
                other.setNext(headNew);
                currentNew.setNext(other);
                currentNew = other;
                newList.tail = currentNew;
                newList.size++;
            }
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
            tail = new Node(data);
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
            tail = new Node(data);
            tail.setNext(tail);
        }
        else{
            Node newNode = new Node(data, tail.getNext());
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }
    public void displayList() {
        try{
            Node current = tail.getNext(); //tail.getNext() is the head of the list in circularly linked list
            do {
                System.out.print(current.getData() + " ");
                current = current.getNext();
            } while (current != tail.getNext());
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
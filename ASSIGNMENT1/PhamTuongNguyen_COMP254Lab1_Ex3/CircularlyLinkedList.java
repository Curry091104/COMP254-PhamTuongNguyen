class CircularlyLinkedList{
    //main
    public static void main(String[] args){
        CircularlyLinkedList myList = new CircularlyLinkedList();

        myList.addLast(1);
        myList.addLast(2);
        myList.addLast(3);
        System.out.print("Initial list: ");
        myList.displayList();


        System.out.print("\nAfter clone: ");
        CircularlyLinkedList cloneList = myList.clone();
        cloneList.displayList();
    }


    private Node tail;
    private int size;
    public int size(){return size;}
    public boolean isEmpty(){return size == 0;}
    public CircularlyLinkedList clone() {
        CircularlyLinkedList newList = new CircularlyLinkedList();
        if (!isEmpty()) {
            Node currentOriginal = tail.getNext();
            Node currentNew = new Node(currentOriginal.getElement(), currentOriginal); 
            newList.tail = currentNew;
            newList.size++;
    
            while (currentOriginal != tail) {
                currentOriginal = currentOriginal.getNext();
                currentNew.setNext(currentOriginal);
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
package PhamTuongNguyen_COMP254Lab1_Ex2;

public class SinglyLinkedList{
    //Test harness
    public static void main(String[] args){
        SinglyLinkedList myList = new SinglyLinkedList();

        // Adding elements to the list
        myList.addFirst(1);
        myList.addLast(2);
        myList.addLast(3);
        myList.addFirst(0);
        myList.addLast(4);
        // Displaying the list
        System.out.print("Initial list: ");
        myList.displayList();

        System.out.println("\nAfter swapping");
        myList.swapNodes(0,4); // swap nodes with data 0 and 4
        myList.displayList();
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
    private Node head;
    private Node tail;
    private int size;
    public int size(){return size;}
    public boolean isEmpty(){return size == 0;}

    public void swapNodes(Object data1, Object data2){
        if(data1 != data2){
            //find Nodes contaning the data1 and the data2
            Node prevNode1 = null;
            Node prevNode2 = null;
            Node node1 = head;
            Node node2 = head;
            //find the data1
            while(node1 != null && node1.getElement() != data1){
                prevNode1 = node1;
                node1 = node1.getNext();
            }
            //find the data2
            while(node2 != null && node2.getElement() != data2){
                prevNode2 = node2;
                node2 = node2.getNext();
            }

            if(node1 == null || node2 == null){return;}
            if(prevNode1 != null){
                prevNode1.setNext(node2); //prev node will connect to the next new node
            }
            else{
                head = node2;
            }
            if(prevNode2 != null){
                prevNode2.setNext(node1); //prev node will connect to the next new node
            }
            else{
                head = node1;
            }

            //Swap the node
            Node tmp = node1.getNext();
            node1.setNext(node2.getNext());
            node2.setNext(tmp);

            //check if tail is swapped
            if(node1.getNext() == null){
                tail = node1;
            }
            if(node2.getNext() == null){
                tail = node2;
            }
        }
    }
    public Object first(){
        if(isEmpty()){
            return null;
        }
        else {
            return head.getElement();
        }
    }
    public Object last(){
        if(isEmpty()){
            return null;
        }
        else {
            return tail.getElement();
        }
    }
    public void addFirst(Object data){
        head = new Node(data, head);
        if(isEmpty()){
            tail = head;
        }
        size++;
    }
    public void addLast(Object data){
        Node newNode = new Node(data, null);
        if(isEmpty()){
            head = tail;
        }
        else{
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }
    public Object removeFirst(){
        if(isEmpty()){
            return null;
        }
        Node newNode = head.getNext();
        head = newNode;
        size--;
        if(isEmpty()){
            tail = null;
        }
        return newNode.getElement();
    }
    public void displayList() {
        try{
            Node current = head;

            while (current != null) {
                System.out.print(current.getElement() + " ");
                current = current.getNext();
            }
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}

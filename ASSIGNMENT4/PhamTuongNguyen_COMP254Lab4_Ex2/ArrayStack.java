package PhamTuongNguyen_COMP254Lab4_Ex2;

interface Stack<E> {
    int size();
    boolean isEmpty();
    void push(E e);
    E pop();
    E top();
}
public class ArrayStack<E> implements Stack<E> {
    private E[] elements;
    public static final int CAPACITY = 100;
    private int t = -1;
    public ArrayStack(){
        this(CAPACITY);
    }
    public ArrayStack(int capacity){
        elements = (E[]) new Object[capacity];
    }
    public int size(){
        return t + 1;
    }
    public boolean isEmpty(){
        return t == -1;
    }
    public void push(E e) throws IllegalStateException{
        // if(size() == elements.length){
        //     throw new IllegalStateException("Stack is full");
        // }
        if(size() == elements.length){
            expand();
        }
        elements[++t] = e;
    }
    public E pop(){
        if(isEmpty()){
            return null;
        }
        if(size() <= elements.length / 3){
            shrink();
        }
        return elements[t--];
    }
    public E top(){
        if(isEmpty()){
            return null;
        }
        return elements[t];
    }
    @Override
    public String toString(){
        if (isEmpty()) {
            return "[]";
        }
        String s = "[" + elements[0];
        for(int i = 1; i <= t; i++){
            s += ", " + elements[i];
        }
        s += "]";
        return s;
    }

    private void expand(){
        E[] copiedEs = (E[]) new Object[elements.length];
        for(int i = 0; i < elements.length; i++){
            copiedEs[i] = elements[i];
        }
        this.elements = (E[]) new Object[copiedEs.length * 2];
        for(int i = 0; i < copiedEs.length; i++){
            this.elements[i] = copiedEs[i];
        }
    }
    private void shrink(){
        E[] copiedEs = (E[]) new Object[elements.length];
        for(int i = 0; i < elements.length; i++){
            copiedEs[i] = elements[i];
        }
        this.elements = (E[]) new Object[copiedEs.length / 2];
        for(int i = 0; i < this.elements.length; i++){
            this.elements[i] = copiedEs[i];
        }
    }
    

    //Solution 1
    public static <E> void transfer(Stack<E> S, Stack<E> T) throws Exception {
        if(S.isEmpty()){
            throw new Exception("Stack S is empty");
        }
        while(!S.isEmpty()){
            E popE = S.pop();
            T.push(popE);
        }
    }
    //Solution 2
    public static <E> void transfer2(ArrayStack<E> S, ArrayStack<E> T) throws Exception {
        if(S.isEmpty()){
            throw new Exception("Stack S is empty");
        }
        if(T.elements.length < S.elements.length){
            T.elements = (E[]) new Object[S.elements.length];
        }
        while(!S.isEmpty()){
            T.elements[++T.t] = S.elements[S.t--];
        }
    }
    public static void main(String[] args) {
        ArrayStack<Integer> S = new ArrayStack<>(3);
        ArrayStack<Integer> T = new ArrayStack<>(3);
        S.push(1);
        S.push(2);
        S.push(3);
        System.out.println("Stack S");
        System.out.println(S);
        try{
            transfer2(S, T);
            System.out.println("After transfering");
            System.out.println("Stack T");
            System.out.println(T);
            System.out.println("Stack S");
            System.out.println(S);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

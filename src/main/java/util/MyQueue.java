
package util;

public class MyQueue<E> {
    private MyArrayList<E>list;
    
    public MyQueue(){
        list=new MyArrayList<>();
    }
    
    /*
    Insert e into the last of queue
    */
    public void enqueue(E e){
        list.addLast(e);
    }
    
    /*
    Extract the element which was inserted first
    */
    public E poll(){
        return list.remove(0);
    }
    
    public boolean isEmpty(){
        return list.isEmpty();
    }
}

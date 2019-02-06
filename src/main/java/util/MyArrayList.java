
package util;


public class MyArrayList<E> {
    private E[]data;
    private int size;
    
    public MyArrayList(){
        int capacity=10;//defaulted capacity
        data=(E[])new Object[capacity];
    }
    
    public int size(){
        return this.size;
    }
    
    public boolean isEmpty(){
        return size==0;
    }
    
    /*
    Insert e to the given index
    */
    public void add(int index,E e){
        if(index<0||index>size){
            throw new IllegalArgumentException("Cannot add the element, index is unvaluable");
        }
        if(size==data.length){
            resize(2*data.length);
        }
        for(int i=size-1;i>=index;i--){
            data[i+1]=data[i];
        }
        data[index]=e;
        size++;
    }
    
    /*
    Insert e to the end of the array
    */
    public void addLast(E e){
        add(size,e);
    }
    
    /*
    Insert e to the begin of the array
    */
    public void addFirst(E e){
        add(0,e);
    }
    
    /**
     * After resizing the capacity of array should be newCap
     * @param newCap the new capacity of the array
     */
    private void resize(int newCap){
        E[]newData=(E[])new Object[newCap];
        for(int i=0;i<size;i++){
            newData[i]=data[i];
        }
        data=newData;
    }
    
    /**
     * Delete the element from the given index
     * @return deleted element
     */
    public E remove(int index){
        if(index<0||index>=size){
            throw new IllegalArgumentException("Cannot remove, index is wrong");
        }
        E deleted=data[index];
        for(int i=index+1;i<size;i++){
            data[i-1]=data[i];
        }
        size--;
        data[size]=null;
        if(size==data.length/4&&data.length/2!=0){
            resize(data.length/2);
        }
        return deleted;
    }
    
    
}

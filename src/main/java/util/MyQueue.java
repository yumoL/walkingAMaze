package util;

public class MyQueue<E> implements Queue<E> {

    private MyArrayList<E> list;

    public MyQueue() {
        list = new MyArrayList<>();
    }

    /**
     * Insert e into the last of queue
     */
    @Override
    public void add(E e) {
        list.addLast(e);
    }

    /**
     * Extract the element which was inserted first
     *
     * @return the extracted element
     */
    @Override
    public E poll() {
        return list.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}

package util;

import java.util.Random;

/**
 *
 * @author luoyumo
 */
public class RandomQueue<E> {

    private MyArrayList<E> queue;
    private Random r;

    public RandomQueue() {
        queue = new MyArrayList<>();
        r = new Random();
    }
    
    /**
     * Add an element to the queue. If the random number is odd, the element will be added to the begin of the queue,
     * Otherwise the element will be added to the end of the queue.
     * @param e The element to be added
     */
    public void add(E e) {
        if (r.nextInt() % 2 == 1) {
            queue.addFirst(e);
        } else {
            queue.addLast(e);
        }
    }
    
    /**
     * Remove an element from the queue. If the random number is odd, the last element of the queue will be removed.
     * Otherwise the first element of the queue will be removed
     * @return the element which was removed
     */
    public E remove() {
        if (queue.isEmpty()) {
            throw new IllegalArgumentException("There's no element to remove in Random Qeuue");
        }

        if (r.nextInt() % 2 == 1) {
            return queue.removeFirst();
        } else {
            return queue.removeLast();
        }
    }

    public int size() {
        return queue.size();
    }

    public boolean empty() {
        return size() == 0;
    }
    
    // only used in unit test
    public MyArrayList<E>getQueue(){
        return this.queue;
    }
    
    // only used in unit tests
    public void setRandom(Random r){
        this.r=r;
    }
}
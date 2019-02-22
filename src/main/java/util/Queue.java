
package util;

/**
 * The interface of normal queue and RandomQueue
 */
public interface Queue<E> {

    /*
    Insert an element
     */
    void add(E e);

    boolean isEmpty();

    /*
    Extract the element
     */
    E poll();
    
}

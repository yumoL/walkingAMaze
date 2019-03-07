
package util;

/**
 * The interface of normal queue and RandomQueue
 */
public interface Queue<E> {

    /**
     * Insert an element
     * @param e 
     */
    void add(E e);

    boolean isEmpty();

    /**
     * Extract an element
     * @return the extracted element
     */
    E poll();
    
}

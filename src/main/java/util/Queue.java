package util;

/**
 * The interface of normal queue and RandomQueue
 */
public interface Queue<E> {

    /**
     * Insert an element
     *
     * @param e the element which is to be added
     */
    void add(E e);

    boolean isEmpty();

    /**
     * Extract an element
     *
     * @return the extracted element
     */
    E poll();

}

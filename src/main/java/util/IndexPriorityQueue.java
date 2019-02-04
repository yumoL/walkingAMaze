package util;

public class IndexPriorityQueue<Element extends Comparable> {

    private Element[] data; //data of the IndexMinHeap
    private int[] indexes; // indexes of the IndexMinHeap  
    private int[] helper; //the place of an index in array indexes   
    private int size;//number of the data
    public int capasity;//Heap can have at most capasity data

    public IndexPriorityQueue(int capasity) {
        this.capasity = capasity;
        data = (Element[]) new Comparable[capasity + 1];        
        indexes = new int[capasity + 1];        
        helper = new int[capasity + 1];        
        for (int i = 0; i <= capasity; i++) {
            helper[i] = 0;
        }        
        size = 0;
    }

    public boolean isEmpty() {
        return size==0;
    }

    /**
     * Add a new data to the heap whose index is i
     *
     * @param i index of the new data
     * @param element the new element itself
     */
    public void add(int i, Element element) {
        if (size >= capasity) {
            throw new IllegalArgumentException("The queue is already full");
        }
        if (i < 0 || i >= capasity) {
            throw new IllegalArgumentException("The index is out of bound");
        }
        if (hasElementInIndex(i)) {
            throw new IllegalArgumentException("There is already an element in this index");
        }

        i++;
        data[i] = element;        
        indexes[size + 1] = i;        
        helper[i] = size + 1;       
        size++;

        shiftup(size);
    }

    /**
     * Extract the smallest element
     *
     * @return the smallest element
     */
    public Element pollElement() {
        if (size <= 0) {
            throw new IllegalStateException("There is nothing to extract becaus the queue is empty");
        }

        Element toBePolled = data[indexes[1]];       
        swapIndexes(1, size);
        helper[indexes[size]] = 0;       
        size--;
        shiftdown(1);
        return toBePolled;
    }

    /**
     * Get the element whose index is i;
     *
     * @param i The index of the element to be returned
     * @return the element whose index is i
     */
    public Element getElement(int i) {
        if (!hasElementInIndex(i)) {
            throw new IllegalArgumentException("Index i doesn't reference to anything");
        }
        return data[i + 1];        
    }

    /**
     * Change the element whose index is i
     *
     * @param i the index of the element to be changed
     * @param newOne new element
     */
    public void change(int i, Element newOne) {
        if (!hasElementInIndex(i)) {
            throw new IllegalArgumentException("Index i doesn't reference to anything");
        }
        i++;
        data[i] = newOne;
        shiftup(helper[i]);
        shiftdown(helper[i]);
    }

    /**
     * Move an index up until its referencing element is smaller than the
     * element that its children index references
     *
     * @param k the index to be moved up
     */
    private void shiftup(int k) {
        while (k > 1 && data[indexes[k / 2]].compareTo(data[indexes[k]]) > 0) {
            swapIndexes(k, k / 2);
            k /= 2;
        }       
    }

    /**
     * Move an index down until its referencing element is bigger than the
     * element that its children index references
     *
     * @param k the index to be moved down
     */
    private void shiftdown(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && data[indexes[j + 1]].compareTo(data[indexes[j]]) < 0) {
                j++;
            }
            
            if (data[indexes[k]].compareTo(data[indexes[j]]) <= 0) {
                break;
            }
           
            swapIndexes(k, j);
            k = j;
        }
    }

    /**
     * Swap two indexes with each other
     */
    private void swapIndexes(int i, int j) {
        int temp = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = temp;
        helper[indexes[i]] = i;
        helper[indexes[j]] = j;        
    }

    /**
     * Check if an index references to an element
     *
     * @param i the index to be checked
     * @return true if there is an element at index i, otherwise false
     */
    private boolean hasElementInIndex(int i) {
        assert i >= 0 && i < capasity;
        return helper[i + 1] != 0;
    }

}

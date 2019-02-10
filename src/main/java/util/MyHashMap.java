package util;

import data.Node;

/**
 * HashMap implementation using chaining
 */
public class MyHashMap {

    class Entry {

        Node key;
        int value;
        Entry next;

        public Entry(Node key, int value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private final int CAPACITY = 12289; //defaulted capacity, should be prime number
    private Entry[] map;

    public MyHashMap() {
        map = new Entry[CAPACITY];
    }

    /*
    Hash function
     */
    private int hash(Node node) {
        return node.hashCode() % CAPACITY;
    }

    /**
     * Get value according to the key
     *
     * @param key
     * @return the value to which the specified key is mapped, or -1 if this map
     * contains no mapping for the key or the key doesn't exist
     */
    public int get(Node key) {
        int h = hash(key);
        if (map[h] == null) {
            return -1;
        }
        Entry entry = map[h];
        while (entry != null && !entry.key.equals(key)) {
            entry = entry.next;
        }
        if (entry == null) {
            return -1;
        }
        return entry.value;
    }

    /**
     * Associate the specified value with the specified key in this map. If the
     * map previously contained a mapping for the key, the old value is
     * replaced.
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     */
    public void put(Node key, int value) {
        int h = hash(key);
        if (map[h] == null) {
            map[h] = new Entry(key, value, null);
        } else {
            Entry entry = map[h];
            while (entry.next != null && !entry.key.equals(key)) {
                entry = entry.next;
            }
            if (entry.key.equals(key)) {
                entry.value = value;
            } else {
                entry.next = new Entry(key, value, null);
            }
        }
    }

    /**
     * Remove the mapping for the specified key from this map if present.
     *
     * @param key key whose mapping is to be removed from the map
     */
    public void remove(Node key) {
        int h = hash(key);
        if (map[h] != null) {
            Entry prevEntry = null;
            Entry entry = map[h];
            while (entry.next != null && !entry.key.equals(key)) {
                prevEntry = entry;
                entry = entry.next;
            }
            if (entry.key.equals(key)) {
                if (prevEntry == null) {
                    map[h] = entry.next;
                } else {
                    prevEntry.next = entry.next;
                }
            }
        }
    }

    /**
     * Determine if the map contains the given key
     *
     * @param key The key whose presence in this map is to be tested
     * @return true if this map contains a mapping for the specified key.
     * Otherwise false
     */
    public boolean containsKey(Node key) {
        int h = hash(key);
        if (map[h] == null) {
            return false;
        }
        Entry entry = map[h];
        while (entry.next != null && !entry.key.equals(key)) {
            entry = entry.next;
        }
        return entry.key.equals(key);
    }
}

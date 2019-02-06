package util;
import java.util.TreeMap;

//TODO
public class MyHashMap<K extends Comparable<K>, V> {
    //a set of possible capacity, should be prime numbers
    private final int[] CAPACITY
            = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
            49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469,
            12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};

    private static final int MAXTOLERANCE = 10;
    private static final int MINTOLERANCE = 2;
    private int capIndex = 0;

    private TreeMap<K, V>[] hashmap;
    private int size;
    private int M;

    public MyHashMap(){
        this.M = CAPACITY[capIndex];
        size = 0;
        hashmap = new TreeMap[M];
        for(int i = 0 ; i < M ; i ++)
            hashmap[i] = new TreeMap<>();
    }
    
    /*
    Hash the key
    */
    public int hash(K key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize(){
        return size;
    }
    
    /**
     * Put a new pair of key and value. If the key is already in the map then overwrite it
     * @param key the key of the pair
     * @param value the value of the pair
     */
    public void put(K key, V value){
        TreeMap<K, V> map = hashmap[hash(key)];
        if(map.containsKey(key))
            map.put(key, value);
        else{
            map.put(key, value);
            size ++;

            if(size >= MAXTOLERANCE * M && capIndex + 1 < CAPACITY.length){
                capIndex ++;
                resize(CAPACITY[capIndex]);
            }
        }
    }
    
    /**
     * Remove the pair with given key
     * @param key the key to be removed
     * @return value of the pair with given key. If the given key doesn't exit in the map, return null
     */
    public V remove(K key){
        V ret = null;
        TreeMap<K, V> map = hashmap[hash(key)];
        if(map.containsKey(key)){
            ret = map.remove(key);
            size --;

            if(size < MINTOLERANCE * M && capIndex - 1 >= 0){
                capIndex --;
                resize(CAPACITY[capIndex]);
            }
        }
        return ret;
    }
    
    /*
    Define if the map contains the given key
    */
    public boolean containsKey(K key){
        return hashmap[hash(key)].containsKey(key);
    }
    
    /*
    Get the value of the pair with given key
    */
    public V get(K key){
        return hashmap[hash(key)].get(key);
    }
    
    /**
     * Resize the hashmap
     * @param newM the new capacity of the hashmap
     */
    private void resize(int newM){
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for(int i = 0 ; i < newM ; i ++)
            newHashTable[i] = new TreeMap<>();

        int oldM = M;
        this.M = newM;
        for(int i = 0 ; i < oldM ; i ++){
            TreeMap<K, V> map = hashmap[i];
            for(K key: map.keySet())
                newHashTable[hash(key)].put(key, map.get(key));
        }

        this.hashmap = newHashTable;
    }
}
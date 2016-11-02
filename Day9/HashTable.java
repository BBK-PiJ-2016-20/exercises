import java.util.Iterator;

/**
 * A hash table that can store multiple values for each key.
 */
public class HashTable<K, V> {
    private SimpleMap<K, GenericStack<V>> storage;

    public HashTable() {
        storage = new SimpleMap<K, GenericStack<V>>();
    }

    /**
     * Adds the value to the list of values associates with the given key.
     */
    public void put(K key, V value) {
        GenericStack<V> l = storage.get(key);
        if (l == null) {
            l = new GenericStack<V>();
            storage.put(key, l);
        }
        l.push(value);
    }

    /**
     * Get an iterator over the values associated with the given key, or null
     * if there is no associated value.
     */
    public Iterator<V> getAll(K key) {
        GenericStack<V> s = storage.get(key);
        if (s == null) {
            return null;
        } 
        return s.iterator();
    } 

    /**
     * Gets the most recently added value for the given key.
     */
    public V getOne(K key) {
        GenericStack<V> s = storage.get(key);
        if (s == null) {
            return null;
        }
        return s.peek();
    }

    /**
     * Remove the most recent value associated with the given key.
     */
    public void deleteOne(K key) {
        storage.get(key).pop(); 
    }

    /**
     * Remove all the values associated with the given key.
     */
    public void deleteAll(K key) {
        storage.delete(key);
    }
}
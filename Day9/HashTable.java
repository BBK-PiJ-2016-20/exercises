import java.util.Iterator;

/**
 * A hash table that can store multiple values for each key.
 */
public class HashTable<K, V> {
    private SimpleMap<K, DoublyLinkedList<V>> storage;

    public HashTable() {
        storage = new SimpleMap<K, DoublyLinkedList<V>>();
    }

    /**
     * Adds the value to the list of values associates with the given key.
     */
    public void put(K key, V value) {
        DoublyLinkedList<V> l = storage.get(key);
        if (l == null) {
            l = new DoublyLinkedList<V>();
            storage.put(key, l);
        }
        l.add(value);
    }

    /**
     * Get an iterator over the values associated with the given key
     */
    public Iterator<V> get(K key) {
        return storage.get(key);
    } 

    /**
     * Remove all the values associated with the given key.
     */
    public void delete(K key) {
        storage.delete(key);
    }
}
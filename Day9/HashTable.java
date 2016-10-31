public class HashTable<K, V> {
    private SimpleMap<K, DoublyLinkedList<V>> storage;

    public HashTable() {
        storage = new SimpleMap<K, DoublyLinkedList<V>>();
    }

    public void put(K key, V value) {
        DoublyLinkedList<V> l = storage.get(key);
        if (l == null) {
            l = new DoublyLinkedList<V>();
            storage.put(key, l);
        }
        l.add(value);
    }

    public DoublyLinkedList<V> get(K key) {
        return storage.get(key);
    } 

    public void delete(K key) {
        storage.delete(key);
    }
}